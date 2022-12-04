package com.bbs.board.service.impl;

import com.bbs.Dto;
import com.bbs.board.dao.BoardDao;
import com.bbs.board.dto.BoardDto;
import com.bbs.board.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardMyBatisServiceImpl implements BoardService {
    private final BoardDao boardDao;

    public BoardMyBatisServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public List<BoardDto> selectAllBoard() {
        return boardDao.selectAll();
    }

    public Object selectAllBoardByKey(HashMap<Object, Object> map) {
        return boardDao.selectAllByKey(map);
    }

    public Dto selectOneBoard(long boardNo) {
        return boardDao.selectOne(boardNo);
    }

    public void insertOneBoard(BoardDto boardDto) {
        boardDao.insertOne(boardDto);
    }

    public void updateOneBoard(BoardDto boardDto) {
        boardDao.updateOne(boardDto);
    }

    public void deleteOneBoard(long boardNo) {
        boardDao.deleteOne(boardNo);
    }

    public void addHit(long boardNo) {
        BoardDto fromDb = boardDao.selectOne(boardNo);
        BoardDto boardDto = BoardDto.of(fromDb.getBoardNo(),
                fromDb.getMemberId(),
                fromDb.getBoardTitle(),
                fromDb.getBoardContent(),
                fromDb.getBoardHit() + 1,
                fromDb.getWriteDate(),
                fromDb.isNotice());
        boardDao.updateOne(boardDto);
    }
}
