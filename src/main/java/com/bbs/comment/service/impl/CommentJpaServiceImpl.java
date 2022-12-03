package com.bbs.comment.service.impl;

import com.bbs.Dto;
import com.bbs.comment.dto.Comment;
import com.bbs.comment.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CommentJpaServiceImpl implements CommentService {
    @Override
    public List<Comment> selectAllComment() {
        return null;
    }

    @Override
    public Object selectAllCommentByKey(HashMap<Object, Object> map) {
        return null;
    }

    @Override
    public Dto selectOneComment(int comment_no) {
        return null;
    }

    @Override
    public void insertOneComment(Comment comment) {

    }

    @Override
    public void updateOneComment(Comment comment) {

    }

    @Override
    public void deleteOneComment(int comment_no) {

    }

    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public void deleteComment(int comment_no) {

    }
}
