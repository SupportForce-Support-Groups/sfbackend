package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;
	
	@Column(name = "body", nullable = false)
	private String postBody;
	
	public Post() {
		
	}

	public Post(String postBody) {
		super();
		this.postBody = postBody;
	}

	public Post(int postId, String postBody) {
		super();
		this.postId = postId;
		this.postBody = postBody;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostBody() {
		return postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}

	@Override
	public String toString() {
		return "\nPost [postId=" + postId + ", postBody=" + postBody + "]";
	}

}
