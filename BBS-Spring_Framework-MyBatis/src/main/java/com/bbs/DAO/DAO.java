package com.bbs.DAO;

import java.util.HashMap;
import java.util.List;

import com.bbs.DTO.DTO;

public interface DAO <T extends DTO> {
	public List<T> selectAll();
	public List<T> selectAllByKey(HashMap<Object, Object> map);
	public DTO selectOne(Object no);	
	public void insertOne(T dto);	
	public void updateOne(T dto);	
	public void deleteOne(Object no);
}
