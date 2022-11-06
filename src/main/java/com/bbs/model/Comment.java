package com.bbs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "comment2")
public class Comment {
    @Id
    private long board_no;
    private long comment_no;
    private long comment_parent;
    private int comment_depth;
    private int comment_seq;
    private String member_id;
    private String comment_content;
    private Timestamp comment_date;
}
