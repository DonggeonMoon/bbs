package com.bbs.member.controller;

import com.bbs.member.dto.Member;
import com.bbs.member.service.MemberService;
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
    public String getLogin(String error,
                           Model model) {
        model.addAttribute("message", this.getErrorMessage(error));

        return "login";
    }

    private Object getErrorMessage(String error) {
        if (error != null) {
            switch (error) {
                case "1":
                    return "아이디를 입력해주세요.";
                case "2":
                    return "존재하지 않는 아이디 입니다.";
                case "3":
                    return "비밀번호가 일치하지 않습니다.";
                default:
                    return "";
            }
        } else {
            return "";
        }
    }

    @PostMapping("/login")
    public String postLogin(HttpSession session,
                            Member member) {
        if ("".equals(member.getMember_id().trim())) {
            return "redirect:/login?error=1";
        }

        if (!memberService.checkId(member.getMember_id())) {
            return "redirect:/login?error=2";
        }

        if (!memberService.checkPw(member.getMember_id(), member.getMember_pw())) {
            return "redirect:/login?error=3";
        }

        memberService.login(member.getMember_id(), session);

        return "redirect:/boardList";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        memberService.logout(session);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public void postRegister(Member member, HttpServletResponse response) throws IOException {
        memberService.register(member);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<meta charset=\"UTF-8\"><script type='text/javascript'>alert('회원 가입 완료');location.href='login';</script>");
    }

    @PostMapping("/checkId")
    @ResponseBody
    public Map<Object, Object> checkId(@RequestBody String member_id) {
        HashMap<Object, Object> map = new HashMap<>();
        if (memberService.checkId(member_id)) {
            map.put("isUnique", false);
        } else {
            map.put("isUnique", true);
        }
        return map;
    }

    @GetMapping("/editMemberInfo")
    public String editMemberInfo(HttpSession session,
                                 Model model) {
        model.addAttribute("memberInfo", memberService.getMemberInfo(session));
        return "editMemberInfo";
    }

    @PostMapping("/editMemberInfo")
    public String editMemberInfo2(Member member) {
        memberService.editMemberInfo(member);
        return "redirect:/boardList";
    }

    @GetMapping("/deleteMemberInfo")
    public void deleteMemberInfo(String member_id,
                                 HttpServletResponse response) throws IOException {
        memberService.deleteMemberInfo(member_id);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<meta charset=\"UTF-8\">" +
                "<script type='text/javascript'>" +
                "alert('탈퇴 완료');location.href='login';" +
                "</script>");
    }

    @GetMapping("managerPage")
    public String managerPage(Model model) {
        model.addAttribute("memberList", memberService.selectAllMember());
        return "managerPage";
    }

    @PostMapping("/changeUserLevel")
    public String changeUserLevel(Member member) {
        memberService.editMemberInfo(member);
        return "redirect:/managerPage";
    }
}
