package com.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbs.DTO.Board;
import com.bbs.DTO.Comment;
import com.bbs.DTO.Member;
import com.bbs.Service.BBSService;

@Controller
public class BBSController {
	
	@Inject
	BBSService service;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String getLogin(String error, Model model) {
		if (error != null) {
			switch(error) {
			case "1" : 
				model.addAttribute("message", "아이디를 입력해주세요.");
				break;
			case "2" : 
				model.addAttribute("message", "존재하지 않는 아이디 입니다.");
				break;
			case "3" :
				model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
				break;
			default:
				model.addAttribute("message", "");
				break;
			}
		} else {
			model.addAttribute("message", "");
		}
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(HttpSession session, Member member) {		
		if (member.getMember_id() != "") {
			if (service.checkId(member.getMember_id())) {
				if(service.checkPw(member.getMember_id(), member.getMember_pw() )) {
					service.login(member.getMember_id(), session);
					return "redirect:/boardList";
				} else return "redirect:/login?error=3";
			} else return "redirect:/login?error=2";
		} return "redirect:/login?error=1";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		service.logout(session);
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String getRegister() {
		return "register";
	}
	
	@PostMapping("/register")
	public void postRegister(Member member, HttpServletResponse response) throws IOException {
		service.register(member);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<meta charset=\"UTF-8\"><script type='text/javascript'>alert('회원 가입 완료');location.href='login';</script>");
	}
	
	@PostMapping("/checkId")
	@ResponseBody
	public Map<Object, Object> checkId(@RequestBody String member_id) {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		if (service.checkId(member_id)) {
			map.put("isUnique", false);
		} else {
			map.put("isUnique", true);
		}
		return map;
	}
	
	@GetMapping("/editMemberInfo")
	public String editMemberInfo(HttpSession session, Model model) {
		model.addAttribute("memberInfo", service.getMemberInfo(session));
		return "editMemberInfo";
	}
	
	@PostMapping("/editMemberInfo")
	public String editMemberInfo2(Member member) {
		service.editMemberInfo(member);		
		return "redirect:/boardList";
	}
	
	@GetMapping("/deleteMemberInfo")
	public void deleteMemberInfo(String member_id, HttpServletResponse response) throws IOException {
		service.deleteMemberInfo(member_id);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<meta charset=\"UTF-8\"><script type='text/javascript'>alert('탈퇴 완료');location.href='login';</script>");
	}
	
	@GetMapping("managerPage")
	public String managerPage(Model model) {
		model.addAttribute("memberList", service.selectAllMember());
		return "managerPage";
	}
	
	@PostMapping("/changeUserLevel")
	public String changeUserLevel(Member member) {
		service.editMemberInfo(member);	
		return "redirect:/managerPage";
	}
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", service.selectAllBoard());
		return "boardList";
	}
	
	@GetMapping("/viewBoard")
	public String viewBoard(Model model, int board_no) {
		service.addHit(board_no);
		model.addAttribute("board", service.selectOneBoard(board_no));
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("key", "board_no");
		map.put("value", board_no);
		model.addAttribute("commentList", service.selectAllCommentByKey(map));
		return "viewBoard";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoard() {
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard2(Board board) {
		service.insertOneBoard(board);
		return "redirect:/boardList";
	}
	
	@GetMapping("/updateBoard")
	public String updateBoard(Model model, int board_no) {
		model.addAttribute("board", service.selectOneBoard(board_no));
		return "updateBoard";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard2(Board board) {
		service.updateOneBoard(board);
		return "redirect:/viewBoard?board_no=" + board.getBoard_no();
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(int board_no) {
		service.deleteOneBoard(board_no);
		return "redirect:/boardList";
	}
	
	@PostMapping("addComment")
	public String addComment(Comment comment) {
		comment.setComment_parent(null);
		service.addComment(comment);
		return "redirect:/viewBoard?board_no=" + comment.getBoard_no();
	}
	
	@PostMapping("addComment2")
	public String addComment2(Comment comment) {
		service.addComment(comment);
		return "redirect:/viewBoard?board_no=" + comment.getBoard_no();
	}
	
	@PostMapping("updateComment")
	public String updateComment(Comment comment) {
		service.updateComment(comment);
		return "redirect:/viewBoard?board_no=" + comment.getBoard_no();
	}
	
	@PostMapping("deleteComment")
	public String deleteComment(int comment_no, int board_no) {
		service.deleteComment(comment_no);
		return "redirect:/viewBoard?board_no=" + board_no;
	}
}
