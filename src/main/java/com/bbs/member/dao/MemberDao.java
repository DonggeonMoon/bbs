package com.bbs.member.dao;

import com.bbs.Dao;
import com.bbs.member.dto.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class MemberDao implements Dao<MemberDto> {
    public MemberDao(SqlSession ss) {
        this.ss = ss;
    }

    private final SqlSession ss;

    final static String NAMESPACE = "memberMapper.";

    @Override
    public List<MemberDto> selectAll() {
        return ss.selectList(NAMESPACE + "selectAll");
    }

    @Override
    public List<MemberDto> selectAllByKey(HashMap<Object, Object> map) {
        return ss.selectList(NAMESPACE + "selectAllByKey", map);
    }

    @Override
    public MemberDto selectOne(Object memberId) {
        return ss.selectOne(NAMESPACE + "selectOne", memberId);
    }

    @Override
    public void insertOne(MemberDto memberDto) {
        ss.insert(NAMESPACE + "insertOne", memberDto);
    }

    @Override
    public void updateOne(MemberDto memberDto) {
        ss.update(NAMESPACE + "updateOne", memberDto);
    }

    @Override
    public void deleteOne(Object memberId) {
        ss.delete(NAMESPACE + "deleteOne", memberId);
    }
}
