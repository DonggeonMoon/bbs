package com.bbs.board.controller;

import com.bbs.board.dto.BoardDto;
import com.bbs.board.service.BoardService;
import com.bbs.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/boardList")
    public String showBoardArticleList(Model model) {
        model.addAttribute("boardList", boardService.selectAllBoard());

        return "boardList";
    }

    @GetMapping("/viewBoard")
    public String showBoardArticle(Model model, long boardNo) throws Exception {
        boardService.addHit(boardNo);
        model.addAttribute("boardDto", boardService.selectOneBoard(boardNo));
        model.addAttribute("commentList", commentService.selectAllCommentByKey("board_no", boardNo));

        return "viewBoard";
    }

    @GetMapping("/insertBoard")
    public String showBoardArticleAddPage() {
        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String addBoardArticle(BoardDto boardDto) {
        boardService.insertOneBoard(boardDto);

        return "redirect:/boardList";
    }

    @GetMapping("/updateBoard")
    public String showBoardArticleModifyPage(Model model, long boardNo) throws Exception {
        model.addAttribute("boardDto", boardService.selectOneBoard(boardNo));

        return "updateBoard";
    }

    @PostMapping("/updateBoard")
    public String modifyBoardArticle(BoardDto boardDto) throws Exception {
        boardService.updateOneBoard(boardDto);

        return "redirect:/viewBoard?boardNo=" + boardDto.getBoardNo();
    }

    @GetMapping("/deleteBoard")
    public String deleteBoardArticle(long boardNo) {
        boardService.deleteOneBoard(boardNo);

        return "redirect:/boardList";
    }
}
