package com.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "post")
@JsonIgnoreProperties(value = {"replies"})
public class Post {
	
	@Id
	@Column(name = "post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	@Column(name = "body", nullable = false)
	private String postBody;
	
	@OneToMany(mappedBy = "rpost", fetch = FetchType.EAGER)
	private List<Reply> replies = new ArrayList<>();
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "user_post", referencedColumnName = "user_id") private
	 * User userPost;
	 */
	
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
	
	 public Post(int postId, String postBody, List<Reply> replies) {
		 super();
		 this.postId = postId; 
		 this.postBody = postBody; 
		 this.replies = replies;
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

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	/*
	 * public User getUserPost() { return userPost; }
	 * 
	 * public void setUser(User userPost) { this.userPost = userPost; }
	 */

	@Override
	public String toString() {
		return "\nPost [postId=" + postId + ", postBody=" + postBody + ", \nreplies=" + replies
				+ "]";
	}
}
