package com.bbs.jpa.model;

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
}
