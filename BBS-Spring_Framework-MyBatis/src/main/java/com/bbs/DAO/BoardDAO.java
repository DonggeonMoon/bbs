package com.bbs.DAO;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bbs.DTO.Board;

@Repository
public class BoardDAO implements DAO<Board> {
	@Inject
	SqlSession ss;
	
	final static String NAMESPACE = "boardMapper.";

	@Override
	public List<Board> selectAll() {
		return ss.selectList(NAMESPACE + "selectAll");
	}
	
	@Override
	public List<Board> selectAllByKey(HashMap<Object, Object> map) {
		return ss.selectList(NAMESPACE + "selectAllByKey", map); 
	}

	@Override
	public Board selectOne(Object board_no) {
		return ss.selectOne(NAMESPACE + "selectOne", board_no);
	}

	@Override
	public void insertOne(Board board) {
		ss.insert(NAMESPACE + "insertOne", board);
	}

	@Override
	public void updateOne(Board board) {
		ss.update(NAMESPACE + "updateOne", board);
		
	}

	@Override
	public void deleteOne(Object board_no) {
		ss.delete(NAMESPACE + "deleteOne", board_no);
	}
}
