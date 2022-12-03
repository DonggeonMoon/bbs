package com.bbs.member.service.impl;

import com.bbs.member.dto.Member;
import com.bbs.member.service.MemberService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MemberJpaServiceImpl implements MemberService {
    @Override
    public boolean checkId(String member_id) {
        return false;
    }

    @Override
    public boolean checkPw(String member_id, String member_pw) {
        return false;
    }

    @Override
    public void login(String member_id, HttpSession session) {

    }

    @Override
    public void logout(HttpSession session) {

    }

    @Override
    public void register(Member member) {

    }

    @Override
    public Member getMemberInfo(HttpSession session) {
        return null;
    }

    @Override
    public void editMemberInfo(Member member) {

    }

    @Override
    public void deleteMemberInfo(String member_id) {

    }

    @Override
    public List<Member> selectAllMember() {
        return null;
    }
}
