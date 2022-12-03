package com.bbs.board.service.impl;

import com.bbs.Dto;
import com.bbs.board.dto.Board;
import com.bbs.board.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BoardJpaServiceImpl implements BoardService {
    @Override
    public List<Board> selectAllBoard() {
        return null;
    }

    @Override
    public Object selectAllBoardByKey(HashMap<Object, Object> map) {
        return null;
    }

    @Override
    public Dto selectOneBoard(int board_no) {
        return null;
    }

    @Override
    public void insertOneBoard(Board board) {

    }

    @Override
    public void updateOneBoard(Board board) {

    }

    @Override
    public void deleteOneBoard(int board_no) {

    }

    @Override
    public void addHit(int board_no) {

    }
}
