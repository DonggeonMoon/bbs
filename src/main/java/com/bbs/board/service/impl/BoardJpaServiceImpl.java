package com.bbs.board.service.impl;

import com.bbs.Dto;
import com.bbs.board.dto.BoardDto;
import com.bbs.board.model.Board;
import com.bbs.board.repository.BoardRepository;
import com.bbs.board.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardJpaServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    public BoardJpaServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<BoardDto> selectAllBoard() {
        return boardRepository.findAll().stream()
                .map(Board::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Object selectAllBoardByKey(HashMap<Object, Object> map) {
        return null;
    }

    @Override
    public Dto selectOneBoard(long boardNo) throws Exception {
        return boardRepository.findById(boardNo).orElseThrow(Exception::new).toDto();
    }

    @Override
    public void insertOneBoard(BoardDto boardDto) {
        boardRepository.save(boardDto.toEntity());
    }

    @Override
    public void updateOneBoard(BoardDto boardDto) throws Exception {
        Board board = boardRepository.findById(boardDto.getBoardNo()).orElseThrow(Exception::new);
        board.update(board.getBoardNo(),
                board.getBoardContent(),
                board.getBoardHit(),
                board.getBoardTitle(),
                board.isNotice(),
                board.getMemberId(),
                board.getWriteDate());
    }

    @Override
    public void deleteOneBoard(long boardNo) {
        boardRepository.deleteById(boardNo);
    }

    @Override
    public void addHit(long boardNo) throws Exception {
        Board fromDb = boardRepository.findById(boardNo).orElseThrow(Exception::new);
        fromDb.update(fromDb.getBoardNo(),
                fromDb.getBoardContent(),
                fromDb.getBoardHit(),
                fromDb.getBoardTitle(),
                fromDb.isNotice(),
                fromDb.getMemberId(),
                fromDb.getWriteDate());
    }
}
