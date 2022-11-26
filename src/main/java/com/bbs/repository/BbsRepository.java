package com.bbs.repository;

import com.bbs.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BbsRepository extends JpaRepository<Board, Long> {
}
