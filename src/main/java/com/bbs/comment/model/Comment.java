package com.bbs.comment.model;

import com.bbs.comment.dto.CommentDto;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "comment2")
public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "board_no")
    private long boardNo;
    @Basic
    @Column(name = "comment_content")
    private String commentContent;
    @Basic
    @Column(name = "comment_date", columnDefinition = "timestamp default current_timestamp()")
    private Timestamp commentDate;
    @Basic
    @Column(name = "comment_depth")
    private int commentDepth;
    @Basic
    @Column(name = "comment_no")
    private long commentNo;
    @Basic
    @Column(name = "comment_parent")
    private long commentParent;
    @Basic
    @Column(name = "comment_seq")
    private int commentSeq;
    @Basic
    @Column(name = "member_id")
    private String memberId;

    public Comment() {
    }

    public Comment(long boardNo, String commentContent, Timestamp commentDate, int commentDepth, long commentNo, long commentParent, int commentSeq, String memberId) {
        this.boardNo = boardNo;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.commentDepth = commentDepth;
        this.commentNo = commentNo;
        this.commentParent = commentParent;
        this.commentSeq = commentSeq;
        this.memberId = memberId;
    }

    public long getBoardNo() {
        return boardNo;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public int getCommentDepth() {
        return commentDepth;
    }

    public long getCommentNo() {
        return commentNo;
    }

    public long getCommentParent() {
        return commentParent;
    }

    public int getCommentSeq() {
        return commentSeq;
    }

    public String getMemberId() {
        return memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment2 = (Comment) o;
        return boardNo == comment2.boardNo && commentDepth == comment2.commentDepth && commentNo == comment2.commentNo && commentParent == comment2.commentParent && commentSeq == comment2.commentSeq && Objects.equals(commentContent, comment2.commentContent) && Objects.equals(commentDate, comment2.commentDate) && Objects.equals(memberId, comment2.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardNo, commentContent, commentDate, commentDepth, commentNo, commentParent, commentSeq, memberId);
    }

    public CommentDto toDto() {
        return new CommentDto(this.boardNo, this.commentNo, this.commentParent, this.commentDepth, this.commentSeq, this.memberId, this.commentContent, this.commentDate);
    }

    public void update(long boardNo, String commentContent, Timestamp commentDate, int commentDepth, long commentNo, long commentParent, int commentSeq, String memberId) {
        this.boardNo = boardNo;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.commentDepth = commentDepth;
        this.commentNo = commentNo;
        this.commentParent = commentParent;
        this.commentSeq = commentSeq;
        this.memberId = memberId;
    }
}
