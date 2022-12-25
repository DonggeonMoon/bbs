package com.bbs.member.service.impl;

import com.bbs.member.dto.MemberDto;
import com.bbs.member.model.Member;
import com.bbs.member.repository.MemberRepository;
import com.bbs.member.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(value = "jpaTransactionManager", readOnly = true)
    public boolean isIdPresent(String memberId) {
        return memberRepository.findById(memberId).isPresent();
    }

    @Override
    @Transactional(value = "jpaTransactionManager", readOnly = true)
    public boolean isPasswordCorrect(String memberId, String memberPw) throws Exception {
        if (memberPw != null) {
            return memberPw.equals(memberRepository.findById(memberId).orElseThrow(Exception::new).getMemberPw());
        }
        return false;
    }

    @Override
    @Transactional(value = "jpaTransactionManager", readOnly = true)
    public String login(HttpSession session, MemberDto memberDto) throws Exception {
        if ("".equals(memberDto.getMemberId().trim())) {
            return "redirect:/login?error=1";
        }

        if (!this.isIdPresent(memberDto.getMemberId())) {
            return "redirect:/login?error=2";
        }

        if (!this.isPasswordCorrect(memberDto.getMemberId(), memberDto.getMemberPw())) {
            return "redirect:/login?error=3";
        }

        session.setAttribute("memberDto", memberRepository.findById(memberDto.getMemberId()).orElseThrow(Exception::new).toDto());

        return "redirect:/boardList";
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public void logout(HttpSession session) {
        session.removeAttribute("member");
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public void register(MemberDto memberDto) {
        memberRepository.save(memberDto.toEntity());
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public MemberDto getMemberInfo(HttpSession session) throws Exception {
        return memberRepository.findById(((MemberDto) session.getAttribute("memberDto")).getMemberId())
                .orElseThrow(Exception::new)
                .toDto();
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public void editMemberInfo(MemberDto memberDto) throws Exception {
        Member member = memberRepository.findById(memberDto.getMemberId()).orElseThrow(Exception::new);
        member.update(memberDto.getMemberId(),
                memberDto.getMemberEmail(),
                memberDto.getMemberPw(),
                memberDto.getRegisterDate(),
                memberDto.getUserLevel());
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public void deleteMemberInfo(String memberId) {
        memberRepository.deleteById(memberId);
    }

    @Override
    @Transactional(value = "jpaTransactionManager", readOnly = true)
    public List<MemberDto> selectAllMember() {
        return memberRepository.findAll().stream()
                .map(Member::toDto)
                .collect(Collectors.toList());
    }
}
