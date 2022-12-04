package com.bbs.comment.service;

import com.bbs.Dto;
import com.bbs.comment.dto.CommentDto;

import java.util.HashMap;
import java.util.List;

public interface CommentService {
    List<CommentDto> selectAllComment();

    Object selectAllCommentByKey(HashMap<Object, Object> map);

    Dto selectOneComment(long commentNo) throws Exception;

    void insertOneComment(CommentDto commentDto);

    void updateOneComment(CommentDto commentDto) throws Exception;

    void deleteOneComment(long commentNo);

    void addComment(CommentDto commentDto);

    void updateComment(CommentDto commentDto) throws Exception;

    void deleteComment(long commentNo);
}
