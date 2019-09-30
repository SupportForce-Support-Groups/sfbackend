package com.project.service;

import java.util.List;

import com.project.model.Post;

public interface PostService {
	
	public Post creationPost(String postBody, int supportGrpId, int userId);
	
	public List<Post> listOfPostForSupportGroup(int sgId);
	
	public Post specificPost(int postId);

}
