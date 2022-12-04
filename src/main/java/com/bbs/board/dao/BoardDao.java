package com.bbs.board.dao;

import com.bbs.board.dto.BoardDto;
import com.bbs.Dao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BoardDao implements Dao<BoardDto> {
    private final SqlSession ss;

    public BoardDao(SqlSession ss) {
        this.ss = ss;
    }

    final static String NAMESPACE = "boardMapper.";

    @Override
    public List<BoardDto> selectAll() {
        return ss.selectList(NAMESPACE + "selectAll");
    }

    @Override
    public List<BoardDto> selectAllByKey(HashMap<Object, Object> map) {
        return ss.selectList(NAMESPACE + "selectAllByKey", map);
    }

    @Override
    public BoardDto selectOne(Object board_no) {
        return ss.selectOne(NAMESPACE + "selectOne", board_no);
    }

    @Override
    public void insertOne(BoardDto boardDto) {
        ss.insert(NAMESPACE + "insertOne", boardDto);
    }

    @Override
    public void updateOne(BoardDto boardDto) {
        ss.update(NAMESPACE + "updateOne", boardDto);

    }

    @Override
    public void deleteOne(Object board_no) {
        ss.delete(NAMESPACE + "deleteOne", board_no);
    }
}
