package com.bbs.board.service;

import com.bbs.Dto;
import com.bbs.board.dto.BoardDto;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
    List<BoardDto> selectAllBoard();

    Object selectAllBoardByKey(HashMap<Object, Object> map);

    Dto selectOneBoard(long boardNo) throws Exception;

    void insertOneBoard(BoardDto boardDto);

    void updateOneBoard(BoardDto boardDto) throws Exception;

    void deleteOneBoard(long boardNo);

    void addHit(long boardNo) throws Exception;
}
