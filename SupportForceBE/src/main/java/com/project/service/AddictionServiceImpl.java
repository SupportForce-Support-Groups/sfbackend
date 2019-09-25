package com.project.service;

import com.project.dao.AddictionDao;
import com.project.dao.AddictionDaoImpl;
import com.project.model.Addiction;

public class AddictionServiceImpl implements AddictionService {
	
	private static AddictionDao addictionDao = new AddictionDaoImpl();
	
	//This method basically returns the object obtained by the selectById() method from the addiction DAO.
	//Returns an addiction object based on the addiction's id.
	@Override
	public Addiction getSpecificAddiction(int id) {
		
		return addictionDao.selectById(id);
	}

}
