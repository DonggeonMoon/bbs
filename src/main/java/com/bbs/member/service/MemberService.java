package com.bbs.member.service;

import com.bbs.member.dto.Member;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface MemberService {
    boolean checkId(String member_id);

    boolean checkPw(String member_id, String member_pw);

    void login(String member_id, HttpSession session);

    void logout(HttpSession session);

    void register(Member member);

    Member getMemberInfo(HttpSession session);

    void editMemberInfo(Member member);

    void deleteMemberInfo(String member_id);

    List<Member> selectAllMember();
}
