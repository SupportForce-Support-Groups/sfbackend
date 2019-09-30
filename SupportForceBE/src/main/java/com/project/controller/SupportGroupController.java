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
	
	//This method creates a get URI for retrieving all the Support Groups associated to a specific user by user id.
	//This method will call the selectUserSupportGroups() method in the SupportGroupServiceImpl class.
	//Will retrieve all the support groups associated to the specific user by user id.
	@GetMapping(value = "getUserSupportGroups{userId}")
	public @ResponseBody List<SupportGroup> getAllUserSupportGroups(@PathVariable("userId") int userId) {
		
		return sgServ.selectUserSupportGroups(userId);
		
	}
	
	@GetMapping(value = "joinSupportGroup{sgId}/{userId}")
	public @ResponseBody SupportGroup joinSupportGroup(@PathVariable("sgId") String supportGrpId, @PathVariable("userId") String userId) {
		
		System.out.println("In the joinSupportGroup() method");
		System.out.println(supportGrpId);
		System.out.println(userId);
		
		return sgServ.joinSupportGroup(Integer.parseInt(supportGrpId), Integer.parseInt(userId));
		
	}
	
	@GetMapping(value="leaveSupportGroup{sgId}/{userId}")
	public @ResponseBody SupportGroup leaveSupportGroup(@PathVariable("sgId") String supportGrpId, @PathVariable("userId") String userId) {
		
		System.out.println("In the leaveSupportGroup() method");
		System.out.println(supportGrpId);
		System.out.println(userId);
		
		return sgServ.leaveSupportGroup(Integer.parseInt(supportGrpId), Integer.parseInt(userId));
		
	}

}
