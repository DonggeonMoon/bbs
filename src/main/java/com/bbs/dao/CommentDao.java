package com.bbs.dao;

import com.bbs.dto.Comment;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class CommentDao implements Dao<Comment> {
    private final SqlSession ss;

    public CommentDao(SqlSession ss) {
        this.ss = ss;
    }

    final static String NAMESPACE = "commentMapper.";

    @Override
    public List<Comment> selectAll() {
        return ss.selectList(NAMESPACE + "selectAll");
    }

    @Override
    public List<Comment> selectAllByKey(HashMap<Object, Object> map) {
        return ss.selectList(NAMESPACE + "selectAllByKey", map);
    }

    @Override
    public Comment selectOne(Object comment_no) {
        return ss.selectOne(NAMESPACE + "selectOne", comment_no);
    }

    @Override
    public void insertOne(Comment comment) {
        ss.insert(NAMESPACE + "insertOne", comment);
    }

    @Override
    public void updateOne(Comment comment) {
        ss.update(NAMESPACE + "updateOne", comment);
    }

    @Override
    public void deleteOne(Object comment_no) {
        ss.delete(NAMESPACE + "deleteOne", comment_no);
    }
}
