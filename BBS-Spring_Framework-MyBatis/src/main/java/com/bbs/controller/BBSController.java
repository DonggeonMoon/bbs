package com.bbs.controller;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bbs.DTO.Board;
import com.bbs.DTO.Comment;
import com.bbs.Service.BBSService;

@Controller
public class BBSController {
	
	@Inject
	BBSService service;
	
	@GetMapping("/")
	public String home() {
		return "home";
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
	
	@PostMapping("/insertBoard2")
	public String insertBoard2(Board board) {
		service.insertOneBoard(board);
		return "redirect:/boardList";
	}
	
	@GetMapping("/updateBoard")
	public String updateBoard(Model model, int board_no) {
		model.addAttribute("board", service.selectOneBoard(board_no));
		return "updateBoard";
	}
	
	@PostMapping("/updateBoard2")
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
