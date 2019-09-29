package com.project.service;

import com.project.model.Post;

public interface PostService {
	
	public Post creationPost(String postBody, int supportGrpId, int userId);

}
