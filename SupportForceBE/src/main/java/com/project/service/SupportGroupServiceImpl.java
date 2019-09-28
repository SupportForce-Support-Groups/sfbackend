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
import com.project.dao.UserDao;
import com.project.dao.UserDaoImpl;
import com.project.model.Addiction;
import com.project.model.SupportGroup;
import com.project.model.User;

@Transactional
@Service("supportGroupServ")
public class SupportGroupServiceImpl implements SupportGroupService {

	private AddictionDao addictionDao = new AddictionDaoImpl();
	private SupportGroupDao sgDao = new SupportGroupDaoImpl();
	private UserDao userDao = new UserDaoImpl();

	public SupportGroupServiceImpl() {

	}

	@Autowired
	public SupportGroupServiceImpl(AddictionDaoImpl addictionDao, SupportGroupDaoImpl sgDao) {
		this.addictionDao = addictionDao;
		this.sgDao = sgDao;
		this.userDao = userDao;
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

	public SupportGroup creationOfSupportGroup(String supportGroupName, int addictionId, int userId) {

		Addiction addiction = addictionDao.selectById(addictionId);

		User user = userDao.selectById(userId);

		SupportGroup supportGrp = new SupportGroup(supportGroupName, addiction);

		sgDao.insert(supportGrp);

		supportGrp.getSupportGroupUsers().add(user);

		return supportGrp;
	}

	@Override
	public List<SupportGroup> selectAllSupportGroups() {

		return sgDao.selectAllSupportGroups();

	}

	@Override
	public List<SupportGroup> selectUserSupportGroups(int userId) {
		List<SupportGroup> allSupportGroups = selectAllSupportGroups();
		List<SupportGroup> userSupportGroups = new ArrayList<>();

		for (int i = 0; i < allSupportGroups.size(); i++) {
			SupportGroup supportGrp = allSupportGroups.get(i);
			List<User> supportGroupUsers = supportGrp.getSupportGroupUsers();
			if (supportGroupUsers.size() != 0) {
				for (int j = 0; j < supportGroupUsers.size(); j++) {
					User user = supportGroupUsers.get(j);
					if (user.getUserId() == userId) {
						userSupportGroups.add(supportGrp);
						break;
					}
				}
			}
		}
		return userSupportGroups;
	}

}
