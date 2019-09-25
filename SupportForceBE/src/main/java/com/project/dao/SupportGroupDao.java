package com.project.dao;

import java.util.List;

import com.project.model.SupportGroup;

public interface SupportGroupDao {
	
	public void insert(SupportGroup mySupportGroup);
	
	public List<SupportGroup> selectAllSupportGroups();
	
	public SupportGroup selectById(int sgId);

}
