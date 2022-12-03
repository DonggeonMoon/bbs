package com.bbs.board.service.impl;

import com.bbs.Dto;
import com.bbs.board.dao.BoardDao;
import com.bbs.board.dto.Board;
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

    public List<Board> selectAllBoard() {
        return boardDao.selectAll();
    }

    public Object selectAllBoardByKey(HashMap<Object, Object> map) {
        return boardDao.selectAllByKey(map);
    }

    public Dto selectOneBoard(int board_no) {
        return boardDao.selectOne(board_no);
    }

    public void insertOneBoard(Board board) {
        boardDao.insertOne(board);
    }

    public void updateOneBoard(Board board) {
        boardDao.updateOne(board);
    }

    public void deleteOneBoard(int board_no) {
        boardDao.deleteOne(board_no);
    }

    public void addHit(int board_no) {
        Board board = (Board) boardDao.selectOne(board_no);
        board.setBoard_hit(board.getBoard_hit() + 1);
        boardDao.updateOne(board);
    }
}
