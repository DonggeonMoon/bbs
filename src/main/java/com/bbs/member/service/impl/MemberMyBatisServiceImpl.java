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

    @Override
    public boolean isIdPresent(String memberId) {
        return memberDao.selectOne(memberId) != null;
    }

    @Override
    public boolean isPasswordCorrect(String memberId, String memberPw) {
        if (memberPw != null) {
            return memberPw.equals(memberDao.selectOne(memberId).getMemberPw());
        }
        return false;
    }

    @Override
    public String login(HttpSession session, MemberDto memberDto) {
        if ("".equals(memberDto.getMemberId().trim())) {
            return "redirect:/login?error=1";
        }

        if (!this.isIdPresent(memberDto.getMemberId())) {
            return "redirect:/login?error=2";
        }

        if (!this.isPasswordCorrect(memberDto.getMemberId(), memberDto.getMemberPw())) {
            return "redirect:/login?error=3";
        }

        session.setAttribute("memberDto", memberDao.selectOne(memberDto.getMemberId()));

        return "redirect:/boardList";
    }

    @Override
    public void logout(HttpSession session) {
        session.removeAttribute("memberDto");
    }

    @Override
    public void register(MemberDto memberDto) {
        memberDao.insertOne(memberDto);
    }

    @Override
    public MemberDto getMemberInfo(HttpSession session) {
        return memberDao.selectOne(((MemberDto) session.getAttribute("memberDto")).getMemberId());
    }

    @Override
    public void editMemberInfo(MemberDto memberDto) {
        memberDao.updateOne(memberDto);
    }

    @Override
    public void deleteMemberInfo(String memberId) {
        memberDao.deleteOne(memberId);
    }

    @Override
    public List<MemberDto> selectAllMember() {
        return memberDao.selectAll();
    }
}
