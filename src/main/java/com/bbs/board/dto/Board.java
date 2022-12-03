package com.bbs.board.dto;

import com.bbs.Dto;

import java.sql.Timestamp;

public class Board implements Dto {
    private long board_no;
    private String member_id;
    private String board_title;
    private String board_content;
    private int board_hit;
    private Timestamp write_date;
    private boolean is_notice;

    public Board() {
        super();
    }

    public Board(long board_no,
                 String member_id,
                 String board_title,
                 String board_content,
                 int board_hit,
                 Timestamp write_date,
                 boolean is_notice) {
        super();
        this.board_no = board_no;
        this.member_id = member_id;
        this.board_title = board_title;
        this.board_content = board_content;
        this.board_hit = board_hit;
        this.write_date = write_date;
        this.is_notice = is_notice;
    }

    public long getBoard_no() {
        return board_no;
    }

    public void setBoard_no(long board_no) {
        this.board_no = board_no;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    public String getBoard_content() {
        return board_content;
    }

    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }

    public int getBoard_hit() {
        return board_hit;
    }

    public void setBoard_hit(int board_hit) {
        this.board_hit = board_hit;
    }

    public Timestamp getWrite_date() {
        return write_date;
    }

    public void setWrite_date(Timestamp write_date) {
        this.write_date = write_date;
    }

    public boolean isIs_notice() {
        return is_notice;
    }

    public void setIs_notice(boolean is_notice) {
        this.is_notice = is_notice;
    }
}
