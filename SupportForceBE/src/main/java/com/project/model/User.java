package com.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "email", nullable = false)
	private String email;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Addiction> addictions;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<SupportGroup> supportGroups;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> posts;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Reply> replies;

	public User() {
		super();
	}

	public User(String username, String password, String email, List<Addiction> addictions, List<SupportGroup> supportGroups,
			List<Post> posts, List<Reply> replies) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.addictions = addictions;
		this.supportGroups = supportGroups;
		this.posts = posts;
		this.replies = replies;
	}

	public User(int userId, String username, String password, String email, List<Addiction> addictions, List<SupportGroup> supportGroups,
			List<Post> posts, List<Reply> replies) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.addictions = addictions;
		this.supportGroups = supportGroups;
		this.posts = posts;
		this.replies = replies;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Addiction> getAddictions() {
		return addictions;
	}

	public void setAddictions(List<Addiction> addictions) {
		this.addictions = addictions;
	}

	public List<SupportGroup> getSupportGroups() {
		return supportGroups;
	}

	public void setSupportGroups(List<SupportGroup> supportGroups) {
		this.supportGroups = supportGroups;
	}


	public List<Post> getPosts() { 
		return posts; 
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Reply> getReplies() {
		return replies; 
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies; 
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", addictions=" + addictions + ", supportGroups=" + supportGroups + ", posts=" + posts + ", replies="
				+ replies + "]";
	}

}
