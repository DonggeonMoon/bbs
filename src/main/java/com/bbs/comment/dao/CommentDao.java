package com.bbs.comment.dao;

import com.bbs.comment.dto.CommentDto;
import com.bbs.Dao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class CommentDao implements Dao<CommentDto> {
    private final SqlSession ss;

    public CommentDao(SqlSession ss) {
        this.ss = ss;
    }

    final static String NAMESPACE = "commentMapper.";

    @Override
    public List<CommentDto> selectAll() {
        return ss.selectList(NAMESPACE + "selectAll");
    }

    @Override
    public List<CommentDto> selectAllByKey(HashMap<Object, Object> map) {
        return ss.selectList(NAMESPACE + "selectAllByKey", map);
    }

    @Override
    public CommentDto selectOne(Object comment_no) {
        return ss.selectOne(NAMESPACE + "selectOne", comment_no);
    }

    @Override
    public void insertOne(CommentDto commentDto) {
        ss.insert(NAMESPACE + "insertOne", commentDto);
    }

    @Override
    public void updateOne(CommentDto commentDto) {
        ss.update(NAMESPACE + "updateOne", commentDto);
    }

    @Override
    public void deleteOne(Object comment_no) {
        ss.delete(NAMESPACE + "deleteOne", comment_no);
    }
}
