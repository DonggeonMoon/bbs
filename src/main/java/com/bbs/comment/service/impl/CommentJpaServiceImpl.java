package com.bbs.comment.service.impl;

import com.bbs.Dto;
import com.bbs.comment.dto.CommentDto;
import com.bbs.comment.model.Comment;
import com.bbs.comment.repository.CommentRepository;
import com.bbs.comment.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentJpaServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentJpaServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDto> selectAllComment() {
        return commentRepository.findAll().stream()
                .map(Comment::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Object selectAllCommentByKey(String key, Object value) {
        return null;
    }

    @Override
    public Dto selectOneComment(long commentNo) throws Exception {
        return commentRepository.findById(commentNo).orElseThrow(Exception::new).toDto();
    }

    @Override
    public void insertOneComment(CommentDto commentDto) {
        commentRepository.save(commentDto.toEntity());
    }

    @Override
    public void updateOneComment(CommentDto commentDto) throws Exception {
        Comment comment = commentRepository.findById(commentDto.getCommentNo()).orElseThrow(Exception::new);
        comment.update(comment.getBoardNo(),
                comment.getCommentContent(),
                comment.getCommentDate(),
                comment.getCommentDepth(),
                comment.getCommentNo(),
                comment.getCommentParent(),
                comment.getCommentSeq(),
                comment.getMemberId()
        );
    }

    @Override
    public void deleteOneComment(long commentNo) {
        commentRepository.deleteById(commentNo);
    }

    @Override
    public void addParentComment(CommentDto commentDto) {
        commentDto.changeIntoParent();
        commentRepository.save(commentDto.toEntity());
    }

    @Override
    public void addComment(CommentDto commentDto) {
        commentRepository.save(commentDto.toEntity());
    }

    @Override
    public void updateComment(CommentDto commentDto) throws Exception {
        Comment comment = commentRepository.findById(commentDto.getCommentNo()).orElseThrow(Exception::new);
        comment.update(comment.getBoardNo(),
                comment.getCommentContent(),
                comment.getCommentDate(),
                comment.getCommentDepth(),
                comment.getCommentNo(),
                comment.getCommentParent(),
                comment.getCommentSeq(),
                comment.getMemberId());
    }

    @Override
    public void deleteComment(long commentNo) {
        commentRepository.deleteById(commentNo);
    }
}
