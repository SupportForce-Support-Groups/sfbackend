package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.AddictionDao;
import com.project.dao.AddictionDaoImpl;
import com.project.model.Addiction;

@Transactional
@Service("addictionServ")
public class AddictionServiceImpl implements AddictionService {
	
	private static AddictionDao addictionDao;
	
	public AddictionServiceImpl() {
		
	}
	
	@Autowired
	public AddictionServiceImpl(AddictionDaoImpl addictionDao) {
		this.addictionDao = addictionDao;
	}
	
	public static AddictionDao getAddictionDao() {
		return addictionDao;
	}

	public static void setAddictionDao(AddictionDao addictionDao) {
		AddictionServiceImpl.addictionDao = addictionDao;
	}

	//This method basically returns the object obtained by the selectById() method from the addiction DAO.
	//Returns an addiction object based on the addiction's id.
	@Override
	public Addiction getSpecificAddiction(int id) {
		
		return addictionDao.selectById(id);
	}
	
	public List<Addiction> getListOfAddictions() {
		
		return addictionDao.selectAllAddictions();
	}

}
