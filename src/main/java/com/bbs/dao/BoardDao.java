package com.bbs.dao;

import com.bbs.dto.Board;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BoardDao implements Dao<Board> {
    private final SqlSession ss;

    public BoardDao(SqlSession ss) {
        this.ss = ss;
    }

    final static String NAMESPACE = "boardMapper.";

    @Override
    public List<Board> selectAll() {
        return ss.selectList(NAMESPACE + "selectAll");
    }

    @Override
    public List<Board> selectAllByKey(HashMap<Object, Object> map) {
        return ss.selectList(NAMESPACE + "selectAllByKey", map);
    }

    @Override
    public Board selectOne(Object board_no) {
        return ss.selectOne(NAMESPACE + "selectOne", board_no);
    }

    @Override
    public void insertOne(Board board) {
        ss.insert(NAMESPACE + "insertOne", board);
    }

    @Override
    public void updateOne(Board board) {
        ss.update(NAMESPACE + "updateOne", board);

    }

    @Override
    public void deleteOne(Object board_no) {
        ss.delete(NAMESPACE + "deleteOne", board_no);
    }
}
