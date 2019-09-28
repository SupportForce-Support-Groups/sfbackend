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
	
	//This method creates a post URI for creating a Support Group.
	//This method will call the creationOfSupportGroup() method in the SupportGroupServiceImpl class.
	//Will create a support group from the information passed in from the angular portion.
	@PostMapping(value = "createSupportGroup{userId}")
	public @ResponseBody SupportGroup creationOfSupportGroup(@RequestBody SupportGroup supportGroup, @PathVariable("userId") int userId) {
		
		System.out.println("In the creationOfSupportGroup() method.");
		System.out.println(supportGroup);
		
		SupportGroup supportGrp = new SupportGroup();
		
		supportGrp.setSupportGroupName(supportGroup.getSupportGroupName());
		supportGrp.setAddict(supportGroup.getAddict());
		
		return sgServ.creationOfSupportGroup(supportGrp.getSupportGroupName(), supportGrp.getAddict().getAddictionId(), userId);
	}
	
	//This method creates a get URI for retrieving all the Support Groups stored in the database.
	//This method will call the getAllSupportGroups() method in the SupportGroupServiceImpl class.
	//Will retrieve all the support groups stored in the database.
	@GetMapping(value = "getAllSupportGroups")
	public @ResponseBody List<SupportGroup> getAllSupportGroups() {
		
		return sgServ.selectAllSupportGroups();
		
	}
	
	//This method creates a get URI for retrieving all the Support Groups associated to a specific user by user id.
	//This method will call the selectUserSupportGroups() method in the SupportGroupServiceImpl class.
	//Will retrieve all the support groups associated to the specific user by user id.
	@GetMapping(value = "getUserSupportGroups{userId}")
	public @ResponseBody List<SupportGroup> getAllUserSupportGroups(@PathVariable("userId") int userId) {
		
		return sgServ.selectUserSupportGroups(userId);
		
	}
	
	@GetMapping(value = "joinSupportGroup")
	public @ResponseBody SupportGroup joinSupportGroup(@RequestBody SupportGroup supportGrp, @RequestBody User user) {
		
		System.out.println("In the joinSupportGroup");
		System.out.println(supportGrp);
		
		
		return null;
	}
	
	

}
