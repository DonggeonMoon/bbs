package com.bbs.comment.controller;

import com.bbs.comment.dto.CommentDto;
import com.bbs.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    private final CommentService commentService;

    public CommentController(@Qualifier("commentJpaServiceImpl") CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/addComment")
    public String addParentComment(CommentDto commentDto) {
        commentService.addParentComment(commentDto);

        return "redirect:/viewBoard?boardNo=" + commentDto.getBoardNo();
    }

    @PostMapping("/addComment2")
    public String addChildComment(CommentDto commentDto) {
        commentService.addComment(commentDto);

        return "redirect:/viewBoard?boardNo=" + commentDto.getBoardNo();
    }

    @PostMapping("/updateComment")
    public String modifyComment(CommentDto commentDto) throws Exception {
        commentService.updateComment(commentDto);

        return "redirect:/viewBoard?boardNo=" + commentDto.getBoardNo();
    }

    @PostMapping("/deleteComment")
    public String deleteComment(long commentNo, long boardNo) {
        commentService.deleteComment(commentNo);

        return "redirect:/viewBoard?boardNo=" + boardNo;
    }
}
