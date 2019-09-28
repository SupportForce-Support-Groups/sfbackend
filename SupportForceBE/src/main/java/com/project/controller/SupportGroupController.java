package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.model.SupportGroup;
import com.project.model.User;
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
	
	@PostMapping(value = "createSupportGroup")
	public @ResponseBody SupportGroup creationOfSupportGroup(@RequestBody SupportGroup supportGroup, @RequestBody User user) {
		
		System.out.println("In the creationOfSupportGroup() method.");
		System.out.println(supportGroup);
		
		SupportGroup supportGrp = new SupportGroup();
		
		supportGrp.setSupportGroupName(supportGroup.getSupportGroupName());
		supportGrp.setAddict(supportGroup.getAddict());
		
		return sgServ.creationOfSupportGroup(supportGrp.getSupportGroupName(), supportGrp.getAddict().getAddictionId(), user.getUserId());
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
