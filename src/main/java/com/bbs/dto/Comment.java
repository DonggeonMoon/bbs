package com.bbs.dto;

import java.sql.Timestamp;

public class Comment implements Dto {
	private long board_no;
	private long comment_no;
	private Object comment_parent;
	private int comment_depth;
	private int comment_seq;
	private String member_id;
	private String comment_content;
	private Timestamp comment_date;
	
	public Comment() {
		super();
	}

	public Comment(long board_no, long comment_no, Object comment_parent, int comment_depth, int comment_seq, String member_id, String comment_content, Timestamp comment_date) {
		super();
		this.board_no = board_no;
		this.comment_no = comment_no;
		this.comment_parent = comment_parent;
		this.comment_depth = comment_depth;
		this.comment_seq = comment_seq;
		this.member_id = member_id;
		this.comment_content = comment_content;
		this.comment_date = comment_date;
	}

	public long getBoard_no() {
		return board_no;
	}

	public void setBoard_no(long board_no) {
		this.board_no = board_no;
	}

	public long getComment_no() {
		return comment_no;
	}

	public void setComment_no(long comment_no) {
		this.comment_no = comment_no;
	}

	public Object getComment_parent() {
		return comment_parent;
	}

	public void setComment_parent(Object comment_parent) {
		this.comment_parent = comment_parent;
	}

	public int getComment_depth() {
		return comment_depth;
	}

	public void setComment_depth(int comment_depth) {
		this.comment_depth = comment_depth;
	}

	public int getComment_seq() {
		return comment_seq;
	}

	public void setComment_seq(int comment_seq) {
		this.comment_seq = comment_seq;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public Timestamp getComment_date() {
		return comment_date;
	}

	public void setComment_date(Timestamp comment_date) {
		this.comment_date = comment_date;
	}
}
