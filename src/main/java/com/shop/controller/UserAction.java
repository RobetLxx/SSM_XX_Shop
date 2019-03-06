package com.shop.controller;

import com.shop.entity.Order;
import com.shop.entity.PageBean;
import com.shop.entity.User;
import com.shop.entity.Visit;
import com.shop.service.*;
import com.shop.util.ShopUtil;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/16  下午7:56
 * @description: 用户控制器
 */

@Controller
@RequestMapping("/user")
public class UserAction {
    @Autowired
    private UserService userService = null;
    @Autowired
    private CategoryService categoryService = null;
    @Autowired
    private GoodsService goodsService = null;
    @Autowired
    private OrderService orderService;
    @Autowired
    private VisitService visitService = null;

    /**
     * 测试用方法
     * @param request
     */
    @RequestMapping("/servletTest")
    public void servletTest(HttpServletRequest request) {
        System.out.println("request.getSession().getServletContext().getRealPath('/')"
                + request.getSession().getServletContext().getRealPath("/"));

    }


    /**
    * 进行登录操作，判断当前的用户名和密码是否正确，如果正确还需将用户信息存放到session里
    * @param 
    * @return 返回对应result
    */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String name, String password, HttpSession session,HttpServletRequest request){
        User user=userService.findUser(name,password);
        if (user == null||user.getStatus()==2){
            return "login";
        }else {
            user.setStatus(1);
            userService.updateStatus(user.getId(),user.getStatus());
            session.setAttribute("user",user);
            user.setIp(getIpAddr(request));
            userService.addLogin(user);
            return "redirect:/index";
        }
    }

    /**
     *获取Ip地址的函数  方便上面的登录模块调用
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    @RequestMapping("/userUpdate")
    public ModelAndView userUpdate(HttpSession session, ModelAndView mv){
        User user=userService.getUser(((User)session.getAttribute("user")).getId());
        mv.addObject("user",user);
        mv.setViewName("usercenter/user_update");
        return mv;
    }

    @RequestMapping("/updateFailed")
    public ModelAndView updateFailed(HttpSession session,ModelAndView mv){
        User user = userService.getUser(((User)session.getAttribute("user")).getId());
        mv.addObject("user",user);
        mv.setViewName("usercenter/user_failed");
        return mv;
    }

    /*
        尝试修改个人信息
    * */
    @RequestMapping("/update")
    public String update(HttpSession session, HttpServletResponse response,String email,String phoneNum,String oldpass,String password) throws IOException{
        User user = userService.getUser(((User)session.getAttribute("user")).getId());
        System.out.println("UserAction :"+phoneNum);
        userService.updateEmail(user.getId(),email);
        userService.updatePhoneNum(user.getId(),phoneNum);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (oldpass.equals("")){
            System.out.println("旧密码为空，不执行密码修改操作");
        }else if (oldpass.equals(user.getPassword())){
            System.out.println("新旧密码相同，可以执行密码操作");
            userService.updatePassword(user.getId(),password);
        }else {
            System.out.println("新旧密码不同，跳转到报错页面");
            out.print("<script language=\"javascript\">alert('原始密码输入错误，修改失败....');window.location.href='/SSM_Shopping/login'</script>");
            return "usercenter/update_failed";
        }
        System.out.println(user.getPassword());
        System.out.println(oldpass);
        return "redirect:/user/userInfo";
    }

    @RequestMapping("/listByPage")
    public String listByPage(Integer page, Model model){
        if (page==null){
            page = new Integer(1);
        }
        PageBean<Visit> pageBean=visitService.getVisitsByPage(page);
        model.addAttribute("pageBean",pageBean);
        return "admin/login_list";
    }

    /**
    	 * 传入商品图片并储存在相应文件夹下
    	 * @param mv
    	 * @param pic
         * @param request
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/uploadTest")
    public ModelAndView uploadTest(ModelAndView mv, MultipartFile pic,HttpServletRequest request)
            throws IllegalStateException,IOException{
//        String FILE_TARGET = "target";
        String basePath = request.getSession().getServletContext().getRealPath("/");/*  "/"表示获取根目录  */
//        basePath = basePath.substring(0,basePath.lastIndexOf(FILE_TARGET));
        String path = basePath + "goodsimage/";
        System.out.println(path);
        //新图片的名称
        String originFileName = pic.getOriginalFilename();
        String newFileName = ShopUtil.getId() +
                originFileName.substring(originFileName.lastIndexOf("."));

        //新的图片
        File newFile = new File(path + newFileName);
        //将内存中的数据写入磁盘
        pic.transferTo(newFile);
        return mv;
    }

    /**
    * 查询
     * 似乎可以直接从session中取出用户基本信息
     * 所以如果不需要更多的信息不需要该方法
    * @param session
     * @param mv
    * @return
    */
    @RequestMapping("/userInfo")
    public ModelAndView userInfo(HttpSession session,ModelAndView mv){
        User user = userService.getUser(((User)session.getAttribute("user")).getId());
        mv.addObject("user",user);
        mv.setViewName("usercenter/user_info");
        return mv;
    }

    /**
    * 实现用户注册的方法
    * @param
    * @return
    */
    @RequestMapping("/register")
    public String register(User user){
//        System.out.println(user.getName());
        //检验各项信息
        userService.register(user);
        return "login";
    }

    //判断是否存在当前的用户信息，用于相应的Ajax的方法
    public  void isexist(User user){
        boolean isexist= userService.isexist(user.getName());
        PrintWriter writer=null;
        try {
            writer = ServletActionContext.getResponse().getWriter();
            writer.print(isexist);
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }

    /*
    * unused
    * 实现上传头像的功能 使用了 org.apache.commons.io.FileUtils 中的静态方法copyFile()
    * @return 返回struts的对应result
    * */
    @RequestMapping("/uploadUserImg")
    public ModelAndView uploadUserImg(HttpSession session,ModelAndView mv,MultipartFile pic,HttpServletRequest request) throws IllegalStateException, IOException {
        User user = userService.getUser(((User)session.getAttribute("user")).getId());
        System.out.println("Now update user_imgs: ");
        if (pic!=null){
            /*
            * dir 获取当前文件存放的目录地址 , suffix 用来获取当前上传的文件的扩展名
            * */
            String basePath=request.getSession().getServletContext().getRealPath("/");
            String dir=basePath+"images/";
            String SavePath="/Users/lingjunhao/IdeaProjects/SSM_XX_Shop/src/main/webapp/images/";
            //新图片的名称
            String originalFileName=pic.getOriginalFilename();
            String newFileName=ShopUtil.getId()+
                    originalFileName.substring(originalFileName.lastIndexOf("."));
            //新的图片
            File newFile=new File(dir+newFileName);
            //将内存写入磁盘中
            pic.transferTo(newFile);

            user.setUser_img("images/"+newFileName);
            (new File(SavePath+user.getUser_img())).delete();
//            user.setUser_img("userimg/"+newFileName);
//            (new File(SavePath+user.getUser_img())).delete();

            //还需要将图片上传到项目中的user_img文件夹下

            File  imgPath=new File(SavePath+newFileName);
            //将内存中的数据写入磁盘
            FileUtils.copyFile(newFile,imgPath);
            //添加到数据库中
            userService.updateUserImg(user.getId(),"images/"+newFileName);
        }
        session.setAttribute("user",user);
        mv.setViewName("/usercenter/index");
        return mv;
//        String userId = ((User) session.getAttribute("user")).getId();
////
////        String dir=ServletActionContext.getServletContext().getRealPath("/user_img");
////        String suffix="";
////        if (avatar!=null){
////            suffix = avatarFileName.substring(avatarFileName.lastIndexOf("."));
////            File saveFile = new File(new File(dir) , userId+suffix);
////            try {
////                FileUtils.copyFile(avatar,saveFile);
////            } catch (IOException e) {
//////                e.printStackTrace();
////            }
////        }
////        //将对应的文件地址信息存放到数据库中
////        userService.updateUserImg(userId,"user_img/"+userId+suffix);
////        ((User)session.getAttribute("user")).setUser_img("user_img/"+userId+suffix);
////        return "/usercenter/index";
    }

    /**
    	 * 实现在线充值功能
    	 * @param session
    	 * @param recharge
    	 * @return
    	 */
    @RequestMapping("/recharge")
    public String recharge(HttpSession session,String recharge){
        User user=(User) session.getAttribute("user");
        float money = user.getMoney()+Float.parseFloat(recharge);
        user.setMoney(money);
        userService.updateMoney(user.getId(),money);
        return "/usercenter/account_log";
    }

    /**
    	 * 后台管理员登录
    	 * @param name 管理员用户名
    	 * @param password 管理员用户密码
     * @param captcha 登录输入验证码
    	 * @return 判断后，返回相应视图名
    	 */
    @RequestMapping("/adminLogin")
    public String adminLogin(String name ,String password ,String captcha , HttpSession session){
        User adminUser = userService.findUser(name,password);
        if (adminUser == null){
            return "/admin/login";
        }
        if (!adminUser.getRole().equals("a")){
            return "/admin/login";
        }
        session.setAttribute("user",adminUser);
        return "/admin/index";
    }

    /*
    * 得到当前所有的用户信息，并显示到用户的信息栏中
    * */
    @RequestMapping("/member")
    public String member(Model model){
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        return "/admin/member_list";
    }

    /**
    	 * 通过id的来删除
     *  实际上是将用户的状态信息设置为2
    	 * @param userId
     * @return
    	 */
    @RequestMapping("/delete")
    public String delete(String userId){
        if (userService.getUser(userId)!=null){
            userService.deleteUser(userId);
        }
        return "redirect:/user/member";
    }

    /**
    	 * 检查当前用户余额是否足够
    	 * @param orderId
    	 * @param session
    	 * @return response
    	 */
    @RequestMapping("/moneyLeftEnough")
    public void moneyLeftEnough(String orderId,HttpSession session,HttpServletResponse response){
        User user =((User)session.getAttribute("user"));
        System.out.println(orderId.getClass()+" got orderId: "+orderId);
        Order order=orderService.getOrder(orderId);
        System.out.println("Finally no more two orders!");
        PrintWriter writer=null;
        try {
            writer=ServletActionContext.getResponse().getWriter();
            writer=response.getWriter();
            if (order.getTotalMoney()<=user.getMoney()){
                writer.print(1);
            }else {
                writer.print(0);
            }
            writer.flush();
        }catch (IOException e){
            System.out.println("Something wrong!");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (writer!=null){
                writer.close();
            }
        }
    }

    /**
    * 用户登出
    * @param 
    * @return 返回登录界面
    */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        User user=(User)session.getAttribute("user");
        user.setStatus(0);//status=0表示不在线
        userService.updateStatus(user.getId(),user.getStatus());
        session.removeAttribute("user");//清空session
        return "login";
    }

    /**
    * 向登录界面跳转
    * @param
    * @return
    */
    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
    * 向注册界面跳转
    * @param 
    * @return
    */
    @RequestMapping(value = "/toRegister")
    public String toRegister(){
        return "register";
    }

    /**
    * 向后台管理员登录页面跳转
    * @param 
    * @return
    */
    @RequestMapping(value = "/toAdminLogin")
    public String toAdminLogin(){
        return "/admin/login";
    }

    /**
     * 向用户中心账户余额页面跳转
     * @return
     */
    @RequestMapping(value="/usercenter/toAccountLog")
    public String toAccountLog() {
        return "/usercenter/account_log";
    }
    /**
     * 向用户中心在线充值页面跳转
     * @return
     */
    @RequestMapping(value="/usercenter/toOnlineRecharge")
    public String toOnlineRecharge() {
        return "/usercenter/online_recharge";
    }

    /**
    * 向用户更改个人头像界面跳转
    * @param 
    * @return 
    */
    @RequestMapping(value="/usercenter/toAvatarChange")
    public String toAvatarChange() { return "usercenter/user_avatar";}

    /**
    * 向购物车界面跳转
    * @param 
    * @return 
    */
    @RequestMapping("toCart")
    public String toCart() {
        return "cart";
    }
}
