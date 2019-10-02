package com.project.service;

import java.util.List;

import com.project.model.SupportGroup;

public interface SupportGroupService {
	
	public SupportGroup creationOfSupportGroup(String supportGroupName, int addictionId, int userId);
	
	public List<SupportGroup> selectAllSupportGroups();
	
	public SupportGroup selectSpecificSupportGroup(int sgId);
	
	public List<SupportGroup> selectUserSupportGroups(int userId);
	
	public SupportGroup joinSupportGroup(int addictionId, int sgId, int userid);

}
