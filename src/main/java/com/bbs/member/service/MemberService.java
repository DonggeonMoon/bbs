package com.bbs.member.service;

import com.bbs.member.dto.MemberDto;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface MemberService {
    boolean isIdPresent(String memberId);

    boolean isPasswordCorrect(String memberId, String memberPw) throws Exception;

    String login(HttpSession session, MemberDto memberDto) throws Exception;

    void logout(HttpSession session);

    void register(MemberDto memberDto);

    MemberDto getMemberInfo(HttpSession session) throws Exception;

    void editMemberInfo(MemberDto memberDto) throws Exception;

    void deleteMemberInfo(String memberId);

    List<MemberDto> selectAllMember();
}
