package com.shop.controller;

import com.shop.entity.Category;
import com.shop.entity.Goods;
import com.shop.entity.PageBean;
import com.shop.service.CategoryService;
import com.shop.service.GoodsService;
import com.shop.util.ShopUtil;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/19  下午4:06
 * @description: 商品Controller
 */

@Controller
@RequestMapping("/goods")
public class GoodsAction {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private GoodsService goodsService;

    /**
    * 商品搜索
    * @param word
    * @param session
     * @param model
     * @return
    */
    @RequestMapping(value = "/search" ,method = RequestMethod.GET)
    public String search(String word , HttpSession session, Model model){
        goodsService.createIndex();
        List<Goods> search_result=goodsService.search(word);
        System.out.println(word);
        int Max=8;
        List<Goods> hotGoodses= goodsService.getGoodsByRole(Max);
        List<Category> categories=categoryService.getCateoriesForIndex();
        model.addAttribute("word", word);
        model.addAttribute("search_result",search_result);
        model.addAttribute("hotGoodses", hotGoodses);
        model.addAttribute("categories",categories);
        return "search_result";
    }


    /**
    *将商品的信息全部显示出来
    * @param goods
     * @param model
    * @return 
    */
    @RequestMapping("/list")
    public String list(Goods goods,Model model){
        List<Goods> goodses = goodsService.getGoods(goods);
        List<Category> categories=categoryService.getCategiries();
        
        model.addAttribute("goodses",goodses);
        model.addAttribute("categories",categories);
        return "/admin/goods_list";
    }
    
    /**
    * 带有所有商品分类的分页，进行分页查询
    * @param page
     * @param goods
     * @param model
    * @return
    */
    @RequestMapping("/listByPage")
    public String listByPage(Integer page,Goods goods,Model model){
        System.out.println("page: "+page+",goods: "+goods);
        List<Category> categories = categoryService.getCategiries();
        if (page==null || page==0){
            page = new Integer(1);
        }
        PageBean<Goods> pageBean=goodsService.getGoodsByPage(page,goods);
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("categories",categories);
        return "admin/goods_list";
    }

    /**
    * 得到添加商品页面的商品号和分类
    * @param model
    * @return
    */
    @RequestMapping("/add")
    public String add(Model model){
        String goodsNo="XX" + ShopUtil.getGoodsNo();
        List<Category> categories=categoryService.getCategiries();
        model.addAttribute("goodsNo",goodsNo);
        model.addAttribute("categories",categories);
        return "admin/goods_add";
    }

    /**
    * 进行商品添加的操作
     * 定义文件变量，用来接收来自前台页面的数据 -->pic
    * @param goods
     * @param mv
     * @param pic
     * @param request
     * @throws IllegalStateException
     * @throws IOException
    * @return
    */
    @RequestMapping("/addoper")
    public ModelAndView addoper(@ModelAttribute("goods") Goods goods,
                                ModelAndView mv, MultipartFile pic,
                                HttpServletRequest request)
            throws IllegalStateException, IOException{
        System.out.println("now and goods:"+goods);
        /*
        * dir 获取当前文件存放的目录地址
        * suffix 用来获取当前上传文件的扩展名
        * */
        String FILE_TARGET="target";
        String basePath=request.getSession().getServletContext().getRealPath("/");// "/":表示获取根目录地址
//        basePath = basePath.substring(0,basePath.lastIndexOf(FILE_TARGET));
        String dir=basePath + "goodsimage/";
        //新图片的名称
        String originFileName = pic.getOriginalFilename();
        String newFileName = ShopUtil.getId()+
                originFileName.substring(originFileName.lastIndexOf("."));
        //新的图片
        File newFile = new File(dir+newFileName);


        //将内存中的数据写入磁盘
        pic.transferTo(newFile);

//        //获取源文件的名称
//        String IMGName=

        //还需要将图片上传到项目中的goodsimage文件夹下
        String SavaPath="/Users/lingjunhao/IdeaProjects/SSM_XX_Shop/src/main/webapp/goodsimage/";
        File  imgPath=new File(SavaPath+newFileName);
        //将内存中的数据写入磁盘
        FileUtils.copyFile(newFile,imgPath);



        if (goods!=null){
            goods.setThumbnail("goodsimage/"+newFileName);
            goodsService.addGoods(goods);
        }
        mv.setViewName("redirect:/goods/listByPage");
        return mv;
    }

    /**
    * 跳转到更新的页面，将分类信息和商品信息带过去
    * @param goodsId
     * @param model
    * @return
    */
    @RequestMapping("/update")
    public String update(String goodsId,Model model){
        List<Category> categories = categoryService.getCategiries();
        Goods goods=goodsService.getGoodsById(goodsId);
        model.addAttribute("goods",goods);
        model.addAttribute("categories",categories);
        return "admin/goods_update";
    }

    /**
    * 更新商品
    * @param goods
     * @param mv
     * @param pic
     * @param request
     * @throws IllegalStateException
     * @throws IOException
    * @return
    */
    @RequestMapping("/updateoper")
    public ModelAndView updateoper(Goods goods,ModelAndView mv,
                                   MultipartFile pic,HttpServletRequest request)
                        throws IllegalStateException,IOException{
        System.out.println("Now update goods: "+goods);
        Goods originGoods = goodsService.getGoodsById(goods.getId());
        if (pic != null){
            /*
            * dir 获取当前文件存放的目录地址
            * suffix 用来获取当前上传的文件的扩展名
            * */
//            String FILE_TARGET="target";
            String basePath = request.getSession().getServletContext().getRealPath("/");// "/":代表获取根目录
//            basePath = basePath.substring(0,basePath.lastIndexOf(FILE_TARGET));
            String dir = basePath + "goodsimage/";
            String path = basePath + "src/main/webapp/";
            String SavaPath="/Users/lingjunhao/IdeaProjects/SSM_XX_Shop/src/main/webapp/goodsimage/";
            //新图片的名称
            String originFileName = pic.getOriginalFilename();
            String newFileName = ShopUtil.getId() +
                    originFileName.substring(originFileName.lastIndexOf("."));
            //新的图片
            File newFile = new File(dir +newFileName);
            //将内存中的数据写入磁盘
            pic.transferTo(newFile);

            goods.setThumbnail("goodsimage/" +newFileName);
            (new File(SavaPath + originGoods.getThumbnail())).delete();

            //还需要将图片上传到项目中的goodsimage文件夹下

            File  imgPath=new File(SavaPath+newFileName);
            //将内存中的数据写入磁盘
            FileUtils.copyFile(newFile,imgPath);

        }
        if (goods.getThumbnail() == null){
            goods.setThumbnail(originGoods.getThumbnail());
            goods.setCategoryId(originGoods.getCategoryId());
        }
        System.out.println("Finally goods is : "+goods);
        goodsService.updateGoods(goods);
        
        mv.setViewName("redirect:/goods/listByPage");
        return mv;
    }

    /**
    * 删除商品
    * @param goodsId
    * @return 
    */
    @RequestMapping("/delete")
    public String delete(String goodsId){
        Goods goods = goodsService.getGoodsById(goodsId);
        goodsService.deleteGoods(goods);
        return "redirect:/goods/listByPage";
    }

    /**
    * 商品分类展示
     * goodsesWithOrder 带有顺序的商品集合
     * order 用来接收页面传输过来的排序规则
     * 通过categoryId 来显示所有的商品
    * @param goodsCategoryId
     * @param order
     * @param mv
    * @return 
    */
    @RequestMapping("/listByCate")
    public ModelAndView listByCate(String goodsCategoryId,String order ,ModelAndView mv){
        //默认按销量排序
        if(order == null){
            order="sellnum";
        }
        Category category = categoryService.getCategoryById(goodsCategoryId);
        List<Category> categories = categoryService.getCategiries();
        //姑且只show 6个商品
        int MAX = 6;
        int TEN = 10;
        List<Goods> goodses=goodsService.getGoodsByOrder(order,MAX,goodsCategoryId);
        List<Goods> goodsesWithOrder=goodsService.getGoodsBySellNum(TEN);
        
        System.out.println(goodsesWithOrder.size());
        
        mv.addObject("category" ,category);
        mv.addObject("categories",categories);
        mv.addObject("goodses",goodses);
        mv.addObject("goodsesWithOrder",goodsesWithOrder);
        mv.setViewName("goods_list");
        return mv;
    }
    
    /**
    * 显示商品的信息
    * @param goodsId
     * @param mv
    * @return 
    */
    @RequestMapping("/view")
    public ModelAndView view(String goodsId,ModelAndView mv){
        Goods goods = goodsService.getGoodsById(goodsId);
        List<Category> categories = categoryService.getCategiries();
        mv.addObject("goods",goods);
        mv.addObject("categories",categories);
        mv.setViewName("goods_view");
        return mv;
    }
    
    /**
    * 带有某一种商品类别的分页
    * @param goods
     * @param page
     * @param model
    * @return
    */
    @RequestMapping("/listByPageCate")
    public String listByPageCate(Goods goods,Integer page,String order, Model model){
        System.out.println(goods);
        System.out.println(page);
        System.out.println(order);
        Category category = categoryService.getCategoryById(goods.getCategoryId());
        if (order ==null){
            order = "sellnum";
        }
        if (page == null){
            page = new Integer(1);
        }if (page == 0){
            page = 1;
        }
        List<Category> categories = categoryService.getCategiries();
        PageBean<Goods> pageBean = goodsService.getGoodsByPageAndOrder(page,goods,order);
        int ShowNum = 10;
        List<Goods> goodses = goodsService.getGoodsByOrder("sellNum",ShowNum,goods.getCategoryId());
        model.addAttribute("category",category);
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("order",order);
        model.addAttribute("categories",categories);
        model.addAttribute("goodses",goodses);

        return "goods_list";
    }

    // 下面可能是实现购物车小窗可视的关键代码
    /*
     * 接受一个字符串，并返回一个字符串
     */
    private String goodsIds;
    private String result;

    /**
     * goodsIds用来接收来自前台的数据：包含了categoryId和num的json字符串
     * result 则返回查询到的信息，也是封装成了一个json字符串
     * @param goodsIds
     * @param model
     * @return
     */
    @RequestMapping("/getGoodsesByIds")
    public String getGoodsesByIds(String goodsIds, Model model) {
        String[] ids = goodsIds.split(",");
        List<Goods> goodses = goodsService.getGoodsByIds(ids);
        JsonConfig c = new JsonConfig();
        c.setExcludes(new String[] { "category", "goodsNo", "categoryId",
                "price1", "stock", "description", "role", "sellTime",
                "sellNum", "score" });
        JSONArray a = JSONArray.fromObject(goodses, c);
        String result = a.toString();
        model.addAttribute("result", result);
        System.out.println(result);
        return "/TestJSP.jsp";
    }


}
