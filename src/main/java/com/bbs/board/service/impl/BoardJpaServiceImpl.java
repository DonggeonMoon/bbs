package com.bbs.board.service.impl;

import com.bbs.Dto;
import com.bbs.board.dto.BoardDto;
import com.bbs.board.model.Board;
import com.bbs.board.repository.BoardRepository;
import com.bbs.board.service.BoardService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public void updateOneBoard(BoardDto boardDto) throws Exception {
        Board board = boardRepository.findById(boardDto.getBoardNo()).orElseThrow(Exception::new);
        System.out.println("board.getBoardContent() = " + board.getBoardContent());
        System.out.println("board.getMemberId() = " + board.getMemberId());
        System.out.println("board.getBoardTitle() = " + board.getBoardTitle());
        board.update(boardDto.getBoardNo(),
                boardDto.getBoardContent(),
                boardDto.getBoardHit(),
                boardDto.getBoardTitle(),
                boardDto.isNotice(),
                boardDto.getMemberId(),
                boardDto.getWriteDate());
        System.out.println("boardDto.getBoardContent() = " + boardDto.getBoardContent());
        System.out.println("board.getBoardContent() = " + board.getBoardContent());
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
