package com.bbs.comment.dto;

import com.bbs.Dto;
import com.bbs.comment.model.Comment;

import java.sql.Timestamp;

public class CommentDto implements Dto {
    private long boardNo;
    private long commentNo;
    private Long commentParent;
    private int commentDepth;
    private int commentSeq;
    private String memberId;
    private String commentContent;
    private Timestamp commentDate;

    public CommentDto() {
    }

    public CommentDto(long boardNo, long commentNo, Long commentParent, int commentDepth, int commentSeq, String memberId, String commentContent, Timestamp commentDate) {
        this.boardNo = boardNo;
        this.commentNo = commentNo;
        this.commentParent = commentParent;
        this.commentDepth = commentDepth;
        this.commentSeq = commentSeq;
        this.memberId = memberId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
    }

    public long getBoardNo() {
        return boardNo;
    }

    public long getCommentNo() {
        return commentNo;
    }

    public Long getCommentParent() {
        return commentParent;
    }

    public int getCommentDepth() {
        return commentDepth;
    }

    public int getCommentSeq() {
        return commentSeq;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public Comment toEntity() {
        return new Comment(this.boardNo, this.commentContent, this.commentDate, this.commentDepth, this.commentNo, this.commentParent, this.commentSeq, this.memberId);
    }

    public static CommentDto of(long boardNo, long commentNo, Long commentParent, int commentDepth, int commentSeq, String memberId, String commentContent, Timestamp commentDate) {
        return new CommentDto(boardNo, commentNo, commentParent, commentDepth, commentSeq, memberId, commentContent, commentDate);
    }

    public void changeIntoParent() {
        this.commentParent = null;
    }
}
