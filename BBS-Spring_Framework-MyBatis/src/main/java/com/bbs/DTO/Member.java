package com.bbs.DTO;

import java.sql.Timestamp;

public class Member implements DTO {
	private String member_id;
	private String member_pw;
	private String member_email;
	private Timestamp register_date;
	private int user_level;
	
	public Member() {
		super();
	}

	public Member(String member_id, String member_pw, String member_email, Timestamp register_date, int user_level) {
		super();
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_email = member_email;
		this.register_date = register_date;
		this.user_level = user_level;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public Timestamp getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Timestamp register_date) {
		this.register_date = register_date;
	}

	public int getUser_level() {
		return user_level;
	}

	public void setUser_level(int user_level) {
		this.user_level = user_level;
	}
}
