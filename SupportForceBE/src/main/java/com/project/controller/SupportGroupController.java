package com.project.controller;

import java.util.LinkedHashMap;
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
	public @ResponseBody Object creationOfSupportGroup(@RequestBody Object supportGroupName, @PathVariable("userId") String userId) {

		System.out.println("In the creationOfSupportGroup() method.");
		System.out.println(userId);
		//        System.out.println(supportGroup.getSupportGroupName());
		//        System.out.println(supportGroup);
		System.out.println(supportGroupName);
		//System.out.println(supportGroupName.getAddictionId());
		LinkedHashMap<String,String> supgrp = (LinkedHashMap<String,String>) supportGroupName;
		int id = Integer.parseInt(supgrp.get("addictionId"));
		String supportName = supgrp.get("supportGroupName");
		System.out.println(id);
		System.out.println(supportName);


		SupportGroup supportGrp = new SupportGroup();

		//        supportGrp.setSupportGroupName(supportGroup.getSupportGroupName());
		//        supportGrp.setAddict(supportGroup);
		//        
		//        System.out.println(supportGroup.getAddict());

		return sgServ.creationOfSupportGroup(supportName, id, Integer.parseInt(userId));
	}


	//This method creates a get URI for retrieving all the Support Groups stored in the database.
	//This method will call the getAllSupportGroups() method in the SupportGroupServiceImpl class.
	//Will retrieve all the support groups stored in the database.
	@GetMapping(value = "getAllSupportGroups")
	public @ResponseBody List<SupportGroup> getAllSupportGroups() {

		return sgServ.selectAllSupportGroups();

	}
	
	@GetMapping(value="getSupportGroup{sgId}")
	public @ResponseBody SupportGroup getSupportGroup(@PathVariable("sgId") String supportGrpId) {
		
		return sgServ.selectSpecificSupportGroup(Integer.parseInt(supportGrpId));
		
	}

	//This method creates a get URI for retrieving all the Support Groups associated to a specific user by user id.
	//This method will call the selectUserSupportGroups() method in the SupportGroupServiceImpl class.
	//Will retrieve all the support groups associated to the specific user by user id.
	@GetMapping(value = "getUserSupportGroups{userId}")
	public @ResponseBody List<SupportGroup> getAllUserSupportGroups(@PathVariable("userId") int userId) {

		return sgServ.selectUserSupportGroups(userId);

	}

	//This method creates a post URI for joining support groups.
	//This method will call the joinSupportGroup() method in the SupportGroupServiceImpl class.
	//Will allow a user to join a support group they choose.
	@PostMapping(value = "joinSupportGroup{userId}")
	public @ResponseBody SupportGroup joinSupportGroup(@RequestBody Object supportGroup, @PathVariable("userId") String userId) {

		System.out.println("In the joinSupportGroup() method");
		System.out.println(supportGroup);
		System.out.println(userId);

		LinkedHashMap<String,String> supportGroupObject = (LinkedHashMap<String, String>) supportGroup;
		int supportGroupId = Integer.parseInt(supportGroupObject.get("groupNumber"));
		int addictionId = Integer.parseInt(supportGroupObject.get("addictionId"));

		return sgServ.joinSupportGroup(addictionId, supportGroupId, Integer.parseInt(userId));

	}

	//This method creates a post URI for leaving support groups.
	//This method will call the leaveSupportGroup() method in the SupportGroupServiceImpl class.
	//Will allow a user to leave a support group they choose.
	@PostMapping(value="leaveSupportGroup{userId}")
	public @ResponseBody SupportGroup leaveSupportGroup(@RequestBody Object supportGroup, @PathVariable("userId") String userId) {

		System.out.println("In the leaveSupportGroup() method");
		System.out.println(supportGroup);
		System.out.println(userId);

		LinkedHashMap<String, String> supportGroupObject = (LinkedHashMap<String, String>) supportGroup;
		int supportGroupId = Integer.parseInt(supportGroupObject.get("groupNumber"));
		int addictionId = Integer.parseInt(supportGroupObject.get("addictionId"));

		return sgServ.leaveSupportGroup(addictionId, supportGroupId, Integer.parseInt(userId));

	}

}
