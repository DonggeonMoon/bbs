package com.bbs.comment.service.impl;

import com.bbs.Dto;
import com.bbs.comment.dao.CommentDao;
import com.bbs.comment.dto.Comment;
import com.bbs.comment.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CommentMyBatisImpl implements CommentService {
    private final CommentDao commentDao;

    public CommentMyBatisImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public List<Comment> selectAllComment() {
        return commentDao.selectAll();
    }

    public Object selectAllCommentByKey(HashMap<Object, Object> map) {
        return commentDao.selectAllByKey(map);
    }

    public Dto selectOneComment(int comment_no) {
        return commentDao.selectOne(comment_no);
    }

    public void insertOneComment(Comment comment) {
        commentDao.insertOne(comment);
    }

    public void updateOneComment(Comment comment) {
        commentDao.updateOne(comment);
    }

    public void deleteOneComment(int comment_no) {
        commentDao.deleteOne(comment_no);
    }

    public void addComment(Comment comment) {
        commentDao.insertOne(comment);
    }

    public void updateComment(Comment comment) {
        commentDao.updateOne(comment);
    }

    public void deleteComment(int comment_no) {
        commentDao.deleteOne(comment_no);
    }
}
