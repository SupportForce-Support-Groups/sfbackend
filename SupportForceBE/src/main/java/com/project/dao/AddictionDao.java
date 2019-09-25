package com.project.dao;

import java.util.List;

import com.project.model.Addiction;

public interface AddictionDao {

	public void insert(Addiction myAddiction);
	
	public List<Addiction> selectAllAddictions();
	
	public Addiction selectById(int id);
}
