package com.bbs.service.impl;

import com.bbs.dto.Board;
import com.bbs.dto.Comment;
import com.bbs.dto.Dto;
import com.bbs.dto.Member;
import com.bbs.repository.BbsRepository;
import com.bbs.service.BbsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Service
public class JpaBbsServiceImpl implements BbsService {
    private final BbsRepository bbsRepository;

    public JpaBbsServiceImpl(BbsRepository bbsRepository) {
        this.bbsRepository = bbsRepository;
    }

    @Override
    public boolean checkId(String member_id) {
        return false;
    }

    @Override
    public boolean checkPw(String member_id, String member_pw) {
        return false;
    }

    @Override
    public void login(String member_id, HttpSession session) {

    }

    @Override
    public void logout(HttpSession session) {

    }

    @Override
    public void register(Member member) {

    }

    @Override
    public Member getMemberInfo(HttpSession session) {
        return null;
    }

    @Override
    public void editMemberInfo(Member member) {

    }

    @Override
    public void deleteMemberInfo(String member_id) {

    }

    @Override
    public List<Member> selectAllMember() {
        return null;
    }

    @Override
    public List<Board> selectAllBoard() {
        return null;
    }

    @Override
    public Object selectAllBoardByKey(HashMap<Object, Object> map) {
        return null;
    }

    @Override
    public Dto selectOneBoard(int board_no) {
        return null;
    }

    @Override
    public void insertOneBoard(Board board) {

    }

    @Override
    public void updateOneBoard(Board board) {

    }

    @Override
    public void deleteOneBoard(int board_no) {

    }

    @Override
    public List<Comment> selectAllComment() {
        return null;
    }

    @Override
    public Object selectAllCommentByKey(HashMap<Object, Object> map) {
        return null;
    }

    @Override
    public Dto selectOneComment(int comment_no) {
        return null;
    }

    @Override
    public void insertOneComment(Comment comment) {

    }

    @Override
    public void updateOneComment(Comment comment) {

    }

    @Override
    public void deleteOneComment(int comment_no) {

    }

    @Override
    public void addHit(int board_no) {

    }

    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public void deleteComment(int comment_no) {

    }
}
