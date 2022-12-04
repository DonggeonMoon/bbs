package com.bbs.member.service.impl;

import com.bbs.member.dao.MemberDao;
import com.bbs.member.dto.MemberDto;
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

    public boolean checkId(String memberId) {
        return memberDao.selectOne(memberId) != null;
    }

    public boolean checkPw(String memberId, String memberPw) {
        return memberDao.selectOne(memberId).getMemberPw().equals(memberPw);
    }

    public void login(String memberId, HttpSession session) {
        session.setAttribute("member", memberDao.selectOne(memberId));
    }

    public void logout(HttpSession session) {
        session.removeAttribute("member");
    }

    public void register(MemberDto memberDto) {
        memberDao.insertOne(memberDto);
    }

    public MemberDto getMemberInfo(HttpSession session) {
        return memberDao.selectOne(((MemberDto) session.getAttribute("member")).getMemberId());
    }

    public void editMemberInfo(MemberDto memberDto) {
        memberDao.updateOne(memberDto);
    }

    public void deleteMemberInfo(String memberId) {
        memberDao.deleteOne(memberId);
    }

    public List<MemberDto> selectAllMember() {
        return memberDao.selectAll();
    }
}
