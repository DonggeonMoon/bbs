package com.bbs.board.service.impl;

import com.bbs.Dto;
import com.bbs.board.dto.BoardDto;
import com.bbs.board.model.Board;
import com.bbs.board.repository.BoardRepository;
import com.bbs.board.service.BoardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(value = "jpaTransactionManager", readOnly = true)
    public List<BoardDto> selectAllBoard() {
        return boardRepository.findAll().stream()
                .map(Board::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public Object selectAllBoardByKey(HashMap<Object, Object> map) {
        return null;
    }

    @Override
    @Transactional(value = "jpaTransactionManager", readOnly = true)
    public Dto selectOneBoard(long boardNo) throws Exception {
        return boardRepository.findById(boardNo).orElseThrow(Exception::new).toDto();
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public void insertOneBoard(BoardDto boardDto) {
        boardRepository.save(boardDto.toEntity());
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public void updateOneBoard(BoardDto boardDto) throws Exception {
        Board board = boardRepository.findById(boardDto.getBoardNo()).orElseThrow(Exception::new);
        board.update(boardDto.getBoardNo(),
                boardDto.getBoardContent(),
                boardDto.getBoardHit(),
                boardDto.getBoardTitle(),
                boardDto.isNotice(),
                boardDto.getMemberId(),
                boardDto.getWriteDate());
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public void deleteOneBoard(long boardNo) {
        boardRepository.deleteById(boardNo);
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
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
