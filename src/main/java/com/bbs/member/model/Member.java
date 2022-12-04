package com.bbs.member.model;

import com.bbs.member.dto.MemberDto;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "member2")
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "member_id")
    private String memberId;
    @Basic
    @Column(name = "member_email")
    private String memberEmail;
    @Basic
    @Column(name = "member_pw")
    private String memberPw;
    @Basic
    @Column(name = "register_date")
    private Timestamp registerDate;
    @Basic
    @Column(name = "user_level")
    private int userLevel;

    public Member() {
    }

    public Member(String memberId, String memberEmail, String memberPw, Timestamp registerDate, int userLevel) {
        this.memberId = memberId;
        this.memberEmail = memberEmail;
        this.memberPw = memberPw;
        this.registerDate = registerDate;
        this.userLevel = userLevel;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public int getUserLevel() {
        return userLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return userLevel == member.userLevel && Objects.equals(memberId, member.memberId) && Objects.equals(memberEmail, member.memberEmail) && Objects.equals(memberPw, member.memberPw) && Objects.equals(registerDate, member.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberEmail, memberPw, registerDate, userLevel);
    }

    public MemberDto toDto() {
        return new MemberDto(this.memberId, this.memberPw, this.memberEmail, this.registerDate, this.userLevel);
    }

    public static Member of(String memberId, String memberEmail, String memberPw, Timestamp registerDate, int userLevel) {
        return new Member(memberId, memberEmail, memberPw, registerDate, userLevel);
    }

    public void update(String memberId, String memberEmail, String memberPw, Timestamp registerDate, int userLevel) {
        this.memberId = memberId;
        this.memberEmail = memberEmail;
        this.memberPw = memberPw;
        this.registerDate = registerDate;
        this.userLevel = userLevel;
    }
}
