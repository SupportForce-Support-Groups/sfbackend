package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.AddictionDao;
import com.project.dao.AddictionDaoImpl;
import com.project.dao.SupportGroupDao;
import com.project.dao.SupportGroupDaoImpl;
import com.project.model.Addiction;
import com.project.model.SupportGroup;
import com.project.model.User;

@Transactional
@Service("supportGroupServ")
public class SupportGroupServiceImpl implements SupportGroupService {
	
	private AddictionDao addictionDao = new AddictionDaoImpl();
	private SupportGroupDao sgDao = new SupportGroupDaoImpl();
	
	public SupportGroupServiceImpl() {
		
	}
	
	@Autowired
	public SupportGroupServiceImpl(AddictionDaoImpl addictionDao, SupportGroupDaoImpl sgDao) {
		this.addictionDao = addictionDao;
		this.sgDao = sgDao;
	}
	
	public AddictionDao getAddictionDao() {
		return addictionDao;
	}

	public void setAddictionDao(AddictionDao addictionDao) {
		this.addictionDao = addictionDao;
	}

	public SupportGroupDao getSgDao() {
		return sgDao;
	}

	public void setSgDao(SupportGroupDao sgDao) {
		this.sgDao = sgDao;
	}

	public SupportGroup creationOfSupportGroup(String supportGroupName, int addictionId) {
		
		Addiction addiction = addictionDao.selectById(addictionId);
		
		SupportGroup supportGrp = new SupportGroup(supportGroupName, addiction);
		
		sgDao.insert(supportGrp);
		
		return supportGrp;
	}
	
	@Override
	public List<SupportGroup> selectAllSupportGroups() {
		
		return sgDao.selectAllSupportGroups();
		
	}
	

	@Override
	public List<SupportGroup> selectUserSupportGroups(int userId) {
		List<SupportGroup> userSupportGroups = new ArrayList<>();
		List<SupportGroup> allSupportGroups = selectAllSupportGroups();
		
		for(int i = 0; i < allSupportGroups.size(); i++) {
			SupportGroup supportGrp = allSupportGroups.get(i);
			List<User> supportGroupUsers = supportGrp.getSupportGroupUsers();
			for(int j = 0; j < supportGroupUsers.size(); j++) {
				if(supportGroupUsers.get(i).getUserId() == userId) {
					userSupportGroups.add(supportGrp);
				}
			}
		}
		return userSupportGroups;
	}
	 

}
