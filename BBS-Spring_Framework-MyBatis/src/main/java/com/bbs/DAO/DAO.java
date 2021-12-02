package com.bbs.DAO;

import java.util.HashMap;
import java.util.List;

import com.bbs.DTO.DTO;

public interface DAO {
	public List<DTO> selectAll();
	public List<DTO> selectAllByKey(HashMap<Object, Object> map);
	public DTO selectOne(Object no);	
	public void insertOne(DTO dto);	
	public void updateOne(DTO dto);	
	public void deleteOne(Object no);
}
