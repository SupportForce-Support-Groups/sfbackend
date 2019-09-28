package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.SupportGroup;
import com.project.service.SupportGroupServiceImpl;

@CrossOrigin("*")
@Controller
public class SupportGroupController {
	
	private static SupportGroupServiceImpl sgServ;

	public SupportGroupController() {

	}
	
	@Autowired
	public SupportGroupController(SupportGroupServiceImpl sgServ) {
		this.sgServ = sgServ;
	}
	
	@GetMapping(value = "getAllSupportGroups")
	public @ResponseBody List<SupportGroup> getAllSupportGroups() {
		
		return sgServ.selectAllSupportGroups();
		
	}
	
	@GetMapping(value = "getUserSupportGroups{userId}")
	public @ResponseBody List<SupportGroup> getAllUserSupportGroups(@PathVariable("userId") int userId) {
		
		return sgServ.selectUserSupportGroups(userId);
		
	}

}
