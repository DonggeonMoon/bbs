package com.bbs.DAO;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bbs.DTO.Member;

@Repository
public class MemberDAO implements DAO<Member> {
	@Inject
	SqlSession ss;
	
	final static String NAMESPACE = "memberMapper.";
	
	@Override
	public List<Member> selectAll() {
		return ss.selectList(NAMESPACE + "selectAll");
	}
	
	@Override
	public List<Member> selectAllByKey(HashMap<Object, Object> map) {
		return ss.selectList(NAMESPACE + "selectAllByKey", map);
	}

	@Override
	public Member selectOne(Object member_id) {
		return ss.selectOne(NAMESPACE + "selectOne", member_id);
	}

	@Override
	public void insertOne(Member member) {
		ss.insert(NAMESPACE + "insertOne", member);
	}

	@Override
	public void updateOne(Member member) {
		ss.update(NAMESPACE + "updateOne", member);
	}

	@Override
	public void deleteOne(Object member_id) {
		ss.delete(NAMESPACE + "deleteOne", member_id);
	}
}
