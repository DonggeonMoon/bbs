package com.bbs.comment.controller;

import com.bbs.comment.dto.Comment;
import com.bbs.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    private final CommentService commentService;

    public CommentController(@Qualifier("commentMyBatisImpl") CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("addComment")
    public String addComment(Comment comment) {
        comment.setComment_parent(null);
        commentService.addComment(comment);
        return "redirect:/viewBoard?board_no=" + comment.getBoard_no();
    }

    @PostMapping("addComment2")
    public String addComment2(Comment comment) {
        commentService.addComment(comment);
        return "redirect:/viewBoard?board_no=" + comment.getBoard_no();
    }

    @PostMapping("updateComment")
    public String updateComment(Comment comment) {
        commentService.updateComment(comment);
        return "redirect:/viewBoard?board_no=" + comment.getBoard_no();
    }

    @PostMapping("deleteComment")
    public String deleteComment(int comment_no, int board_no) {
        commentService.deleteComment(comment_no);
        return "redirect:/viewBoard?board_no=" + board_no;
    }
}
