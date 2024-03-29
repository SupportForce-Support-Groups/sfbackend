package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reply")
public class Reply {
	
	@Id
	@Column(name = "reply_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int replyId;
	
	@Column(name = "body", nullable = false)
	private String replyBody;
	
	@ManyToOne
	@JoinColumn(name="rpost", referencedColumnName = "post_id")
	private Post rpost;
	
	public Reply() {
		
	}

	public Reply(String replyBody, Post rpost) {
		super();
		this.replyBody = replyBody;
		this.rpost = rpost;
	}

	public Reply(int replyId, String replyBody, Post rpost) {
		super();
		this.replyId = replyId;
		this.replyBody = replyBody;
		this.rpost = rpost;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplyBody() {
		return replyBody;
	}

	public void setReplyBody(String replyBody) {
		this.replyBody = replyBody;
	}

	public Post getRpost() {
		return rpost;
	}

	public void setPost(Post rpost) {
		this.rpost = rpost;
	}

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", replyBody=" + replyBody + ", rpost=" + rpost.getPostBody() + "]";
	}

}