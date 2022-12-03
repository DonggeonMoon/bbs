package com.bbs.board.service;

import com.bbs.Dto;
import com.bbs.board.dto.Board;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
    List<Board> selectAllBoard();

    Object selectAllBoardByKey(HashMap<Object, Object> map);

    Dto selectOneBoard(int board_no);

    void insertOneBoard(Board board);

    void updateOneBoard(Board board);

    void deleteOneBoard(int board_no);

    void addHit(int board_no);
}
