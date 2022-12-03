package com.bbs.member.service.impl;

import com.bbs.member.dao.MemberDao;
import com.bbs.member.dto.Member;
import com.bbs.member.service.MemberService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MemberMyBatisServiceImpl implements MemberService {
    private final MemberDao memberDao;

    public MemberMyBatisServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public boolean checkId(String member_id) {
        return memberDao.selectOne(member_id) != null;
    }

    public boolean checkPw(String member_id, String member_pw) {
        return memberDao.selectOne(member_id).getMember_pw().equals(member_pw);
    }

    public void login(String member_id, HttpSession session) {
        session.setAttribute("member", memberDao.selectOne(member_id));
    }

    public void logout(HttpSession session) {
        session.removeAttribute("member");
    }

    public void register(Member member) {
        memberDao.insertOne(member);
    }

    public Member getMemberInfo(HttpSession session) {
        return memberDao.selectOne(((Member) session.getAttribute("member")).getMember_id());
    }

    public void editMemberInfo(Member member) {
        memberDao.updateOne(member);
    }

    public void deleteMemberInfo(String member_id) {
        memberDao.deleteOne(member_id);
    }

    public List<Member> selectAllMember() {
        return memberDao.selectAll();
    }
}
