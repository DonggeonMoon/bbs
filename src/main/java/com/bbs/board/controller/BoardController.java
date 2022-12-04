package com.bbs.board.controller;

import com.bbs.board.dto.BoardDto;
import com.bbs.board.service.BoardService;
import com.bbs.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;

@Controller
public class BoardController {
    private final BoardService boardService;
    private final CommentService commentService;

    public BoardController(@Qualifier("boardMyBatisServiceImpl") BoardService boardService,
                           @Qualifier("commentMyBatisImpl") CommentService commentService) {
        this.boardService = boardService;
        this.commentService = commentService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/boardList")
    public String boardList(Model model) {
        model.addAttribute("boardList", boardService.selectAllBoard());
        return "boardList";
    }

    @GetMapping("/viewBoard")
    public String viewBoard(Model model,
                            int board_no) throws Exception {
        boardService.addHit(board_no);
        model.addAttribute("board", boardService.selectOneBoard(board_no));
        HashMap<Object, Object> map = new HashMap<>();
        map.put("key", "board_no");
        map.put("value", board_no);
        model.addAttribute("commentList", commentService.selectAllCommentByKey(map));
        return "viewBoard";
    }

    @GetMapping("/insertBoard")
    public String insertBoard() {
        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard2(BoardDto boardDto) {
        boardService.insertOneBoard(boardDto);
        return "redirect:/boardList";
    }

    @GetMapping("/updateBoard")
    public String updateBoard(Model model,
                              int board_no) throws Exception {
        model.addAttribute("board", boardService.selectOneBoard(board_no));
        return "updateBoard";
    }

    @PostMapping("/updateBoard")
    public String updateBoard2(BoardDto boardDto) throws Exception {
        boardService.updateOneBoard(boardDto);
        return "redirect:/viewBoard?board_no=" + boardDto.getBoardNo();
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(int board_no) {
        boardService.deleteOneBoard(board_no);
        return "redirect:/boardList";
    }
}
