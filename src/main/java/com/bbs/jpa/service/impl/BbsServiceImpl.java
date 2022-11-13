package com.bbs.jpa.service.impl;

import com.bbs.jpa.repository.BoardRepository;
import com.bbs.jpa.service.BbsService;
import com.bbs.mybatis.dto.Board;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BbsServiceImpl implements BbsService {
    private final BoardRepository boardRepository;

    public BbsServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> selectAllBoard() {
        return boardRepository.findAll();
    }

    public Optional<Board> selectOneBoard(long board_no) {
        return boardRepository.findById(board_no);
    }

    public void insertOneBoard(Board board) {
        boardRepository.save(board);
    }

    public void updateOneBoard(Board board) {
        boardRepository.findById(board.getBoard_no());
    }

    public void deleteOneBoard(int board_no) {
        boardRepository.deleteById((long) board_no);
    }

}
