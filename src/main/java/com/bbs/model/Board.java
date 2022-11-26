package com.bbs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "board2")
public class Board {
    @Id
    private long board_no;
    private String member_id;
    private String board_title;
    private String board_content;
    private int board_hit;
    private Timestamp write_date;
    private boolean is_notice;

    public long getBoard_no() {
        return board_no;
    }

    public String getMember_id() {
        return member_id;
    }

    public String getBoard_title() {
        return board_title;
    }

    public String getBoard_content() {
        return board_content;
    }

    public int getBoard_hit() {
        return board_hit;
    }

    public Timestamp getWrite_date() {
        return write_date;
    }

    public boolean isIs_notice() {
        return is_notice;
    }
}
