package com.shop.service.impl;

import com.shop.dao.CommentDao;
import com.shop.entity.Comment;
import com.shop.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lingjunhao
 * create at:  19/2/19  上午11:45
 * @description: 评论service接口
 */

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao = null;

    public CommentDao getCommentDao() {
        return commentDao;
    }

    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public List<Comment> getCommentsByGoodsId(String goodsId) {
        return commentDao.getCommentsByTargetId(goodsId);
    }

    @Override
    public List<Comment> getCommentByOwnerId(String ownerId) {
        return commentDao.getCommentsByOwnerId(ownerId);
    }

    /*
    * 添加评论*/
    @Override
    public void addComment(Comment comment) {
        commentDao.addComment(comment);
    }

    /*
    * 查询所有的评论*/
    @Override
    public List<Comment> getComments() {
        return commentDao.getCommentsInOrder();
    }

    /*
    * 按id查询评论*/
    @Override
    public Comment getCommentById(String commentId) {
        return commentDao.getCommentById(commentId);
    }

    @Override
    public void deleteById(String commentId) {
        Comment comment=commentDao.getCommentById(commentId);
        //删除针对商品的评论(statusNum=0)
        //需要删除对该回复的回复
        if (comment.getStatusnum()==0){
            List<Comment> reCommentList=commentDao.getCommentsByTargetId(commentId);
            for (Comment c:reCommentList){
                commentDao.deleteById(c.getId());
            }
        }
        commentDao.deleteById(commentId);
    }
}
