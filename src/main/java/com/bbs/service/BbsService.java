package com.bbs.service;

import com.bbs.dto.Board;
import com.bbs.dto.Comment;
import com.bbs.dto.Dto;
import com.bbs.dto.Member;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public interface BbsService {
    boolean checkId(String member_id);

    boolean checkPw(String member_id, String member_pw);

    void login(String member_id, HttpSession session);

    void logout(HttpSession session);

    void register(Member member);

    Member getMemberInfo(HttpSession session);

    void editMemberInfo(Member member);

    void deleteMemberInfo(String member_id);

    List<Member> selectAllMember();

    List<Board> selectAllBoard();

    Object selectAllBoardByKey(HashMap<Object, Object> map);

    Dto selectOneBoard(int board_no);

    void insertOneBoard(Board board);

    void updateOneBoard(Board board);

    void deleteOneBoard(int board_no);

    List<Comment> selectAllComment();

    Object selectAllCommentByKey(HashMap<Object, Object> map);

    Dto selectOneComment(int comment_no);

    void insertOneComment(Comment comment);

    void updateOneComment(Comment comment);

    void deleteOneComment(int comment_no);

    void addHit(int board_no);

    void addComment(Comment comment);

    void updateComment(Comment comment);

    void deleteComment(int comment_no);
}
