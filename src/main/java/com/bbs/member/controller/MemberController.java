package com.bbs.member.controller;

import com.bbs.member.dto.MemberDto;
import com.bbs.member.service.MemberService;
import com.bbs.util.BbsUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(@Qualifier("memberMyBatisServiceImpl") MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String showLoginPage(String error, Model model) {
        model.addAttribute("message", BbsUtils.getErrorMessage(error));

        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session, MemberDto memberDto) throws Exception {
        return memberService.login(session, memberDto);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        memberService.logout(session);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public void register(MemberDto memberDto, HttpServletResponse response) throws IOException {
        memberService.register(memberDto);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<meta charset=\"UTF-8\"><script type='text/javascript'>alert('회원 가입 완료');location.href='login';</script>");
    }

    @PostMapping("/checkId")
    @ResponseBody
    public Map<Object, Object> checkId(@RequestBody String memberId) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("isUnique", !memberService.isIdPresent(memberId));

        return map;
    }

    @GetMapping("/editMemberInfo")
    public String showMemberInfoModifyPage(HttpSession session, Model model) throws Exception {
        model.addAttribute("memberInfo", memberService.getMemberInfo(session));

        return "editMemberInfo";
    }

    @PostMapping("/editMemberInfo")
    public String modifyMemberInfo(MemberDto memberDto) throws Exception {
        memberService.editMemberInfo(memberDto);

        return "redirect:/boardList";
    }

    @GetMapping("/deleteMemberInfo")
    public void deleteMemberInfo(String memberId, HttpServletResponse response) throws IOException {
        memberService.deleteMemberInfo(memberId);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<meta charset=\"UTF-8\">" +
                "<script type='text/javascript'>" +
                "alert('탈퇴 완료');location.href='login';" +
                "</script>");
    }

    @GetMapping("/managerPage")
    public String showManagerPage(Model model) {
        model.addAttribute("memberList", memberService.selectAllMember());

        return "managerPage";
    }

    @PostMapping("/changeUserLevel")
    public String changeUserLevel(MemberDto memberDto) throws Exception {
        memberService.editMemberInfo(memberDto);

        return "redirect:/managerPage";
    }
}
