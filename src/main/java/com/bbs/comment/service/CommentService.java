package com.bbs.comment.service;

import com.bbs.Dto;
import com.bbs.comment.dto.Comment;

import java.util.HashMap;
import java.util.List;

public interface CommentService {
    List<Comment> selectAllComment();

    Object selectAllCommentByKey(HashMap<Object, Object> map);

    Dto selectOneComment(int comment_no);

    void insertOneComment(Comment comment);

    void updateOneComment(Comment comment);

    void deleteOneComment(int comment_no);

    void addComment(Comment comment);

    void updateComment(Comment comment);

    void deleteComment(int comment_no);
}
