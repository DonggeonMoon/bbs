package com.bbs.board.model;

import com.bbs.board.dto.BoardDto;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "board2")
public class Board {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "board_no")
    private long boardNo;
    @Basic
    @Column(name = "board_content")
    private String boardContent;
    @Basic
    @Column(name = "board_hit")
    private int boardHit;
    @Basic
    @Column(name = "board_title")
    private String boardTitle;
    @Basic
    @Column(name = "is_notice")
    private boolean isNotice;
    @Basic
    @Column(name = "member_id")
    private String memberId;
    @Basic
    @Column(name = "write_date", columnDefinition = "timestamp default current_timestamp()")
    private Timestamp writeDate;

    public Board() {
    }

    public Board(long boardNo, String boardContent, int boardHit, String boardTitle, boolean isNotice, String memberId, Timestamp writeDate) {
        this.boardNo = boardNo;
        this.boardContent = boardContent;
        this.boardHit = boardHit;
        this.boardTitle = boardTitle;
        this.isNotice = isNotice;
        this.memberId = memberId;
        this.writeDate = writeDate;
    }

    public long getBoardNo() {
        return boardNo;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public int getBoardHit() {
        return boardHit;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public boolean isNotice() {
        return isNotice;
    }

    public String getMemberId() {
        return memberId;
    }

    public Timestamp getWriteDate() {
        return writeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board2 = (Board) o;
        return boardNo == board2.boardNo && boardHit == board2.boardHit && isNotice == board2.isNotice && Objects.equals(boardContent, board2.boardContent) && Objects.equals(boardTitle, board2.boardTitle) && Objects.equals(memberId, board2.memberId) && Objects.equals(writeDate, board2.writeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardNo, boardContent, boardHit, boardTitle, isNotice, memberId, writeDate);
    }

    public BoardDto toDto() {
        return new BoardDto(this.boardNo, this.memberId, this.boardTitle, this.boardContent, this.boardHit, this.writeDate, this.isNotice);
    }

    public void update(long boardNo, String boardContent, int boardHit, String boardTitle, boolean isNotice, String memberId, Timestamp writeDate) {
        this.boardNo = boardNo;
        this.boardContent = boardContent;
        this.boardHit = boardHit;
        this.boardTitle = boardTitle;
        this.isNotice = isNotice;
        this.memberId = memberId;
        this.writeDate = writeDate;
    }
}
