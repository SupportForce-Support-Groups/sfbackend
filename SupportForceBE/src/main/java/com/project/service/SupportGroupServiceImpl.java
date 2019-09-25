package com.project.service;

import com.project.dao.AddictionDao;
import com.project.dao.AddictionDaoImpl;
import com.project.dao.SupportGroupDao;
import com.project.dao.SupportGroupDaoImpl;
import com.project.model.Addiction;
import com.project.model.SupportGroup;

public class SupportGroupServiceImpl implements SupportGroupService {
	
	private AddictionDao addictionDao = new AddictionDaoImpl();
	private SupportGroupDao sgDao = new SupportGroupDaoImpl();
	
	public SupportGroup creationOfSupportGroup(String supportGroupName, int addictionId) {
		
		Addiction addiction = addictionDao.selectById(addictionId);
		
		SupportGroup supportGrp = new SupportGroup(supportGroupName, addiction);
		
		sgDao.insert(supportGrp);
		
		return supportGrp;
	}

}
