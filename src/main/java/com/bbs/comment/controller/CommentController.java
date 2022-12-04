package com.bbs.comment.controller;

import com.bbs.comment.dto.CommentDto;
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
    public String addComment(CommentDto commentDto) {
        CommentDto parentCommentDto = CommentDto.of(commentDto.getBoardNo(),
                commentDto.getCommentNo(),
                null,
                commentDto.getCommentDepth(),
                commentDto.getCommentSeq(),
                commentDto.getMemberId(),
                commentDto.getCommentContent(),
                commentDto.getCommentDate()
        );
        commentService.addComment(parentCommentDto);
        return "redirect:/viewBoard?board_no=" + commentDto.getBoardNo();
    }

    @PostMapping("addComment2")
    public String addComment2(CommentDto commentDto) {
        commentService.addComment(commentDto);
        return "redirect:/viewBoard?board_no=" + commentDto.getBoardNo();
    }

    @PostMapping("updateComment")
    public String updateComment(CommentDto commentDto) throws Exception {
        commentService.updateComment(commentDto);
        return "redirect:/viewBoard?board_no=" + commentDto.getBoardNo();
    }

    @PostMapping("deleteComment")
    public String deleteComment(int comment_no, int board_no) {
        commentService.deleteComment(comment_no);
        return "redirect:/viewBoard?board_no=" + board_no;
    }
}
