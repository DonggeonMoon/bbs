package com.bbs.Service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bbs.DAO.BoardDAO;
import com.bbs.DAO.CommentDAO;
import com.bbs.DAO.MemberDAO;
import com.bbs.DTO.Board;
import com.bbs.DTO.Comment;
import com.bbs.DTO.DTO;

@Service
public class BBSService {
	@Inject
	BoardDAO bdao;
	
	@Inject
	CommentDAO cdao;
	
	@Inject
	MemberDAO mdao;
	
	public List<DTO> selectAllBoard() {
		return bdao.selectAll();
	}
	
	public Object selectAllBoardByKey(HashMap<Object, Object> map) {
		return bdao.selectAllByKey(map);
	}
	
	public DTO selectOneBoard(int board_no) {
		return bdao.selectOne(board_no);
	}
	
	public void insertOneBoard(Board board) {
		bdao.insertOne(board);
	}
	
	public void updateOneBoard(Board board) {
		bdao.updateOne(board);
	}

	public void deleteOneBoard(int board_no) {
		bdao.deleteOne(board_no);
	}
	
	public List<DTO> selectAllComment() {
		return cdao.selectAll();
	}
	
	public Object selectAllCommentByKey(HashMap<Object, Object> map) {
		return cdao.selectAllByKey(map);
	}
	
	public DTO selectOneComment(int comment_no) {
		return cdao.selectOne(comment_no);
	}
	
	public void insertOneComment(Comment comment) {
		cdao.insertOne(comment);
	}
	
	public void updateOneComment(Comment comment) {
		cdao.updateOne(comment);
	}

	public void deleteOneComment(int comment_no) {
		cdao.deleteOne(comment_no);
	}
	
	public void addHit(int board_no) {
		Board board = (Board) bdao.selectOne(board_no);
		board.setBoard_hit(board.getBoard_hit() + 1);
		bdao.updateOne(board);		
	}
	
	public void addComment(Comment comment) {
		cdao.insertOne(comment);
	}
	
	public void updateComment(Comment comment) {
		cdao.updateOne(comment);
	}
	
	public void deleteComment(int comment_no) {
		cdao.deleteOne(comment_no);
	}
}
