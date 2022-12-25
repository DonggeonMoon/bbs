package com.bbs.comment.service.impl;

import com.bbs.Dto;
import com.bbs.comment.dto.CommentDto;
import com.bbs.comment.model.Comment;
import com.bbs.comment.repository.CommentRepository;
import com.bbs.comment.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentJpaServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentJpaServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    @Transactional(value = "jpaTransactionManager", readOnly = true)
    public List<CommentDto> selectAllComment() {
        return commentRepository.findAll().stream()
                .map(Comment::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public Object selectAllCommentByKey(String key, Object value) {
        return null;
    }

    @Override
    @Transactional(value = "jpaTransactionManager", readOnly = true)
    public Dto selectOneComment(long commentNo) throws Exception {
        return commentRepository.findById(commentNo).orElseThrow(Exception::new).toDto();
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public void insertOneComment(CommentDto commentDto) {
        commentRepository.save(commentDto.toEntity());
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
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
    @Transactional(value = "jpaTransactionManager")
    public void deleteOneComment(long commentNo) {
        commentRepository.deleteById(commentNo);
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public void addParentComment(CommentDto commentDto) {
        commentDto.changeIntoParent();
        commentRepository.save(commentDto.toEntity());
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public void addComment(CommentDto commentDto) {
        commentRepository.save(commentDto.toEntity());
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public void updateComment(CommentDto commentDto) throws Exception {
        Comment comment = commentRepository.findById(commentDto.getCommentNo()).orElseThrow(Exception::new);
        comment.update(commentDto.getBoardNo(),
                commentDto.getCommentContent(),
                commentDto.getCommentDate(),
                commentDto.getCommentDepth(),
                commentDto.getCommentNo(),
                commentDto.getCommentParent(),
                commentDto.getCommentSeq(),
                commentDto.getMemberId());
    }

    @Override
    @Transactional(value = "jpaTransactionManager")
    public void deleteComment(long commentNo) {
        commentRepository.deleteById(commentNo);
    }
}
