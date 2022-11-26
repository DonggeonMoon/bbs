package com.bbs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "member2")
public class Member {
    @Id
    private String member_id;
    private String member_pw;
    private String member_email;
    private Timestamp register_date;
    private int user_level;
}
