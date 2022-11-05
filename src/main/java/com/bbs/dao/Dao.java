package com.bbs.dao;

import java.util.HashMap;
import java.util.List;

import com.bbs.dto.Dto;

public interface Dao<T extends Dto> {
	public List<T> selectAll();
	public List<T> selectAllByKey(HashMap<Object, Object> map);
	public Dto selectOne(Object no);
	public void insertOne(T dto);	
	public void updateOne(T dto);	
	public void deleteOne(Object no);
}
