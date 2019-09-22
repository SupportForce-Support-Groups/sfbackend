package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	public Reply() {
		
	}

	public Reply(String replyBody) {
		super();
		this.replyBody = replyBody;
	}

	public Reply(int replyId, String replyBody) {
		super();
		this.replyId = replyId;
		this.replyBody = replyBody;
	}

	@Override
	public String toString() {
		return "\nReply [replyId=" + replyId + ", replyBody=" + replyBody + "]";
	}

}