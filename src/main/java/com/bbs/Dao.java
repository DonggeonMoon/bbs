package com.bbs;

import java.util.HashMap;
import java.util.List;

import com.bbs.Dto;

public interface Dao<T extends Dto> {
	List<T> selectAll();
	List<T> selectAllByKey(HashMap<Object, Object> map);
	Dto selectOne(Object no);
	void insertOne(T dto);	
	void updateOne(T dto);	
	void deleteOne(Object no);
}
