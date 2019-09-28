package com.project.service;

import java.util.List;

import com.project.model.SupportGroup;

public interface SupportGroupService {
	
	public SupportGroup creationOfSupportGroup(String supportGroupName, int addictionId);
	
	public List<SupportGroup> selectAllSupportGroups();

}
