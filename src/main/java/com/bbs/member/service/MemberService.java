package com.bbs.member.service;

import com.bbs.member.dto.MemberDto;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface MemberService {
    boolean checkId(String memberId);

    boolean checkPw(String memberId, String memberPw) throws Exception;

    void login(String memberId, HttpSession session);

    void logout(HttpSession session);

    void register(MemberDto memberDto);

    MemberDto getMemberInfo(HttpSession session);

    void editMemberInfo(MemberDto memberDto) throws Exception;

    void deleteMemberInfo(String memberId);

    List<MemberDto> selectAllMember();
}
