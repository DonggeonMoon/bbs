package com.bbs.comment.service.impl;

import com.bbs.Dto;
import com.bbs.comment.dao.CommentDao;
import com.bbs.comment.dto.CommentDto;
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

    @Override
    public List<CommentDto> selectAllComment() {
        return commentDao.selectAll();
    }

    @Override
    public Object selectAllCommentByKey(String key, Object value) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("key", key);
        map.put("value", value);
        return commentDao.selectAllByKey(map);
    }

    @Override
    public Dto selectOneComment(long commentNo) {
        return commentDao.selectOne(commentNo);
    }

    @Override
    public void insertOneComment(CommentDto commentDto) {
        commentDao.insertOne(commentDto);
    }

    @Override
    public void updateOneComment(CommentDto commentDto) {
        commentDao.updateOne(commentDto);
    }

    @Override
    public void deleteOneComment(long commentNo) {
        commentDao.deleteOne(commentNo);
    }

    @Override
    public void addParentComment(CommentDto commentDto) {
        commentDto.changeIntoParent();
        commentDao.insertOne(commentDto);
    }

    @Override
    public void addComment(CommentDto commentDto) {
        commentDao.insertOne(commentDto);
    }

    @Override
    public void updateComment(CommentDto commentDto) {
        commentDao.updateOne(commentDto);
    }

    @Override
    public void deleteComment(long commentNo) {
        commentDao.deleteOne(commentNo);
    }
}
