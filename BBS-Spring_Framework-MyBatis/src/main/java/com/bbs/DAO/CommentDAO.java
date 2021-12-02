package com.bbs.DAO;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bbs.DTO.Comment;
import com.bbs.DTO.DTO;

@Repository
public class CommentDAO implements DAO {
	@Inject
	SqlSession ss;
	
	final static String NAMESPACE = "commentMapper.";

	@Override
	public List<DTO> selectAll() {
		return ss.selectList(NAMESPACE + "selectAll");
	}
	
	@Override
	public List<DTO> selectAllByKey(HashMap<Object, Object> map) {
		return ss.selectList(NAMESPACE + "selectAllByKey", map);
	}
	
	@Override
	public Comment selectOne(Object comment_no) {
		return ss.selectOne(NAMESPACE + "selectOne", comment_no);
	}

	@Override
	public void insertOne(DTO comment) {
		ss.insert(NAMESPACE + "insertOne", comment);
	}

	@Override
	public void updateOne(DTO comment) {
		ss.update(NAMESPACE + "updateOne", comment);
	}

	@Override
	public void deleteOne(Object comment_no) {
		ss.delete(NAMESPACE + "deleteOne", comment_no);
	}
}
