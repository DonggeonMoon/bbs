package com.bbs.member.service.impl;

import com.bbs.member.dto.MemberDto;
import com.bbs.member.model.Member;
import com.bbs.member.repository.MemberRepository;
import com.bbs.member.service.MemberService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberJpaServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberJpaServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public boolean checkId(String memberId) {
        return memberRepository.findById(memberId).isPresent();
    }

    @Override
    public boolean checkPw(String memberId, String memberPw) throws Exception {
        return memberRepository.findById(memberId).orElseThrow(Exception::new).getMemberPw().equals(memberPw);
    }

    @Override
    public void login(String memberId, HttpSession session) {
        session.setAttribute("member", memberRepository.findById(memberId));
    }

    @Override
    public void logout(HttpSession session) {
        session.removeAttribute("member");
    }

    @Override
    public void register(MemberDto memberDto) {
        memberRepository.save(memberDto.toEntity());
    }

    @Override
    public MemberDto getMemberInfo(HttpSession session) {
        return null;
    }

    @Override
    public void editMemberInfo(MemberDto memberDto) throws Exception {
        Member member = memberRepository.findById(memberDto.getMemberId()).orElseThrow(Exception::new);
        member.update(member.getMemberId(),
                member.getMemberEmail(),
                member.getMemberPw(),
                member.getRegisterDate(),
                member.getUserLevel());
    }

    @Override
    public void deleteMemberInfo(String memberId) {
        memberRepository.deleteById(memberId);
    }

    @Override
    public List<MemberDto> selectAllMember() {
        return memberRepository.findAll().stream()
                .map(Member::toDto)
                .collect(Collectors.toList());
    }
}
