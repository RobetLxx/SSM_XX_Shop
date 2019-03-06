package com.shop.service;

import com.shop.entity.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> getCommentsByGoodsId(String goodsId);

    public List<Comment> getCommentByOwnerId(String ownerId);

    public void addComment(Comment comment);
    
    /**
    * 查询数据库所有的评论
    * @param
    * @return
    */
    public List<Comment> getComments();

    /**
    * 按照评论id查询评论
    * @param commentId
    * @return 
    */
    public Comment getCommentById(String commentId);

    public void deleteById(String commentId);

}
