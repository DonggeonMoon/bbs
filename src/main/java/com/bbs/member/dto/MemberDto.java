package com.bbs.member.dto;

import com.bbs.Dto;
import com.bbs.member.model.Member;

import java.sql.Timestamp;

public class MemberDto implements Dto {
    private String memberId;
    private String memberPw;
    private String memberEmail;
    private Timestamp registerDate;
    private int userLevel;

    public MemberDto() {
    }

    public MemberDto(String memberId, String memberPw, String memberEmail, Timestamp registerDate, int userLevel) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberEmail = memberEmail;
        this.registerDate = registerDate;
        this.userLevel = userLevel;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public Member toEntity() {
        return new Member(this.memberId, this.memberPw, this.memberEmail, this.registerDate, this.userLevel);
    }

    public static MemberDto of(String memberId, String memberPw, String memberEmail, Timestamp registerDate, int userLevel) {
        return new MemberDto(memberId, memberPw, memberEmail, registerDate, userLevel);
    }
}
