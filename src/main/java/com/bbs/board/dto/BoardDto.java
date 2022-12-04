package com.bbs.board.dto;

import com.bbs.Dto;
import com.bbs.board.model.Board;

import java.sql.Timestamp;

public class BoardDto implements Dto {
    private long boardNo;
    private String memberId;
    private String boardTitle;
    private String boardContent;
    private int boardHit;
    private Timestamp writeDate;
    private boolean isNotice;

    public BoardDto() {
    }

    public BoardDto(long boardNo, String memberId, String boardTitle, String boardContent, int boardHit, Timestamp writeDate, boolean isNotice) {
        this.boardNo = boardNo;
        this.memberId = memberId;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardHit = boardHit;
        this.writeDate = writeDate;
        this.isNotice = isNotice;
    }

    public long getBoardNo() {
        return boardNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public int getBoardHit() {
        return boardHit;
    }

    public Timestamp getWriteDate() {
        return writeDate;
    }

    public boolean isNotice() {
        return isNotice;
    }

    public Board toEntity() {
        return new Board(this.boardNo, this.memberId, this.boardHit, this.boardTitle, this.isNotice, this.memberId, this.writeDate);
    }

    public static BoardDto of(long boardNo, String memberId, String boardTitle, String boardContent, int boardHit, Timestamp writeDate, boolean isNotice) {
        return new BoardDto(boardNo, memberId, boardTitle, boardContent, boardHit, writeDate, isNotice);
    }
}
