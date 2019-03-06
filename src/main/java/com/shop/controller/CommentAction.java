package com.shop.controller;

import com.shop.entity.Comment;
import com.shop.entity.User;
import com.shop.service.CommentService;
import com.shop.util.ShopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lingjunhao
 * create at:  19/2/19  下午3:15
 * @description: 商品评论controller
 */
@Controller
@RequestMapping("/comment")
public class CommentAction {
    @Autowired
    private CommentService commentService=null;
    
    /**
    * 获取当前商品的评论
     * ajax异步发送请求
     * 返回JSON格式的数据
    * @param goodsId
    * @return 
    */
    @RequestMapping("/getCommentsByGoodsId")
    @ResponseBody
    public Map<String,Object> getCommentsByGoodsId(String goodsId){
        Map<String ,Object> commentsInfo = new HashMap<>();
        List<Comment> comments=commentService.getCommentsByGoodsId(goodsId);
        commentsInfo.put("comments",comments);
        return commentsInfo;
    }
    
    /**
    * 查询针对某一评价的用户评论
    * @param commentId
     * @param mv
    * @return 
    */
    @RequestMapping("/listReCommentAboutGoods")
    public ModelAndView listReCommentAboutGoods(String commentId, ModelAndView mv){
        Comment comment=commentService.getCommentById(commentId);
        List<Comment> reComments=commentService.getCommentsByGoodsId(commentId);
        mv.addObject("reComments",reComments);
        mv.addObject("comment",comment);
        mv.setViewName("recomment_list");
        return mv;
    }
    
    /**
    * 后台管理员删除评论
    * @param commentId
     * @param mv
    * @return 
    */
    @RequestMapping("/adminDelete")
    public ModelAndView adminDelete(String commentId,ModelAndView mv){
        System.out.println("Now delete commentId "+commentId);
        commentService.deleteById(commentId);
        mv.setViewName("redirect:/comment/list");
        return mv;
    }
    
    /**
    * 删除评论
    * @param commentId
     * @param mv
    * @return
    */
    @RequestMapping("/delete")
    public ModelAndView delete(String commentId,ModelAndView mv){
        System.out.println("Now delete commentId "+commentId);
        commentService.deleteById(commentId);
        mv.setViewName("redirect:/comment/listByUser");
        return mv;
    }

    /**
    * 查看评论
    * @param commentId
     * @param mv
    * @return
    */
    @RequestMapping("/view")
    public ModelAndView view(String commentId,ModelAndView mv){
        System.out.println(commentId);
        Comment comment = commentService.getCommentById(commentId);
        System.out.println(comment);
        mv.addObject("comment",comment);
        mv.setViewName("admin/comment_view");
        return mv;
    }

    /**
    * 列出所有的评论，排序优先级：商品、用户、时间
    * @param mv
    * @return
    */
    @RequestMapping("/list")
    public ModelAndView list(ModelAndView mv){
        List<Comment> commentList=commentService.getComments();
        System.out.println(commentList.get(0));
        mv.addObject("commentList",commentList);
        mv.setViewName("admin/comment_list");
        return mv;
    }

    /**
    * 查询某一个用户发出的评论
    * @param session
     * @param mv
    * @return
    */
    @RequestMapping("/listByUser")
    public ModelAndView listByUser(HttpSession session,ModelAndView mv){
        String userId=((User)session.getAttribute("user")).getId();
        List<Comment> commentList=commentService.getCommentByOwnerId(userId);
        mv.addObject("commentList",commentList);
        mv.setViewName("/usercenter/comment_list");
        return mv;
    }

    /**
    * 增加评论
    * @param session
     * @param comment
     * @param statusNum
     * @param mv
     * @param targetId
     * @param score
    * @return
    */
    @RequestMapping("/addComment")
    public ModelAndView addComment(HttpSession session,Comment comment,String statusNum,
                                   ModelAndView mv,String targetId,String score){
        comment.setId(ShopUtil.getId());
        comment.setOwnerid(((User)session.getAttribute("user")).getId());
        comment.setTargetid(targetId);
        comment.setStatusnum(Integer.parseInt(statusNum));
        if (score!=null){
            //评价不为空，为
            comment.setScore(Integer.parseInt(score));
            mv.addObject("goodsId",targetId);
            mv.setViewName("redirect:/goods/view");
        }else {
            //对评价的回复，是否要跳转到其他地方
            mv.addObject("commentId",targetId);
            mv.setViewName("redirect:/comment/listReCommentAboutGoods");
        }
        comment.setCreatetime(ShopUtil.getNow());
        System.out.println(comment);
        commentService.addComment(comment);
        return mv;
    }
}
