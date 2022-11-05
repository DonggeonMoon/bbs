package com.bbs.service;

import com.bbs.dao.BoardDao;
import com.bbs.dao.CommentDao;
import com.bbs.dao.MemberDao;
import com.bbs.dto.Board;
import com.bbs.dto.Comment;
import com.bbs.dto.Dto;
import com.bbs.dto.Member;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class BbsService {
    @Inject
    BoardDao bdao;

    @Inject
    CommentDao cdao;

    @Inject
    MemberDao mdao;

    public boolean checkId(String member_id) {
        return ((mdao.selectOne(member_id) != null) ? true : false);
    }

    public boolean checkPw(String member_id, String member_pw) {
        return ((((Member) mdao.selectOne(member_id)).getMember_pw().equals(member_pw)) ? true : false);
    }

    public void login(String member_id, HttpSession session) {
        session.setAttribute("member", mdao.selectOne(member_id));
    }

    public void logout(HttpSession session) {
        session.removeAttribute("member");
    }

    public void register(Member member) {
        mdao.insertOne(member);
    }

    public Member getMemberInfo(HttpSession session) {
        return mdao.selectOne(((Member) session.getAttribute("member")).getMember_id());
    }

    public void editMemberInfo(Member member) {
        mdao.updateOne(member);
    }

    public void deleteMemberInfo(String member_id) {
        mdao.deleteOne(member_id);
    }

    public List<Member> selectAllMember() {
        return mdao.selectAll();
    }

    public List<Board> selectAllBoard() {
        return bdao.selectAll();
    }

    public Object selectAllBoardByKey(HashMap<Object, Object> map) {
        return bdao.selectAllByKey(map);
    }

    public Dto selectOneBoard(int board_no) {
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

    public List<Comment> selectAllComment() {
        return cdao.selectAll();
    }

    public Object selectAllCommentByKey(HashMap<Object, Object> map) {
        return cdao.selectAllByKey(map);
    }

    public Dto selectOneComment(int comment_no) {
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
