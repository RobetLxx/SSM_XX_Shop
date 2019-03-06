package com.shop.dao;

import com.shop.entity.Comment;

import java.util.List;

public interface CommentDao {
    /**
    * 获得针对目标id的评论
    * @param targetId
    * @return
    */
    public List<Comment> getCommentsByTargetId(String targetId);

    /**
    * 获得传入用户的评论列表
    * @param ownerId
    * @return
    */
    public List<Comment> getCommentsByOwnerId(String ownerId);
    
    /**
    	 * 实现增加评论
    	 * @param comment
    	 * @param
    	 */
    public void addComment(Comment comment);

    /**
    	 * 获取以时间排序的用户评价
     * 按照年月日-时分秒格式的字符串，字符串排序即时间排序
    	 * @param 
    	 */
    public List<Comment> getCommentsInOrder();

    /**
    * 根据Id来查询评论
    * @param commentId
    * @return
    */
    public Comment getCommentById(String commentId);

    /**
    * 删除评论
    * @param commentId
    * @return
    */
    public void deleteById(String commentId);
}
