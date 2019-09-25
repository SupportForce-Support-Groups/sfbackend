package com.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "support_group")
public class SupportGroup {
	
	@Id
	@Column(name = "support_group_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supportGroupId;
	
	@Column(name = "support_group_name", nullable = false)
	private String supportGroupName;
	
	@ManyToMany(mappedBy = "supportGroups", fetch = FetchType.LAZY)
	private List<User> supportGroupUsers = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "addict", referencedColumnName = "addiction_id")
	private Addiction addict;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> postList = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Reply> replyList = new ArrayList<>();
	
	public SupportGroup() {
		super();
	}
	
	public SupportGroup(String supportGroupName, Addiction addict) {
		super();
		this.supportGroupName = supportGroupName;
		this.addict = addict;
	}

	public SupportGroup(int supportGroupId, String supportGroupName, List<User> supportGroupUsers, Addiction addict,
			List<Post> postList, List<Reply> replyList) {
		super();
		this.supportGroupId = supportGroupId;
		this.supportGroupName = supportGroupName;
		this.supportGroupUsers = supportGroupUsers;
		this.addict = addict;
		this.postList = postList;
		this.replyList = replyList;
	}

	public int getSupportGroupId() {
		return supportGroupId;
	}

	public void setSupportGroupId(int supportGroupId) {
		this.supportGroupId = supportGroupId;
	}

	public String getSupportGroupName() {
		return supportGroupName;
	}

	public void setSupportGroupName(String supportGroupName) {
		this.supportGroupName = supportGroupName;
	}

	public List<User> getSupportGroupUsers() {
		return supportGroupUsers;
	}

	public void setSupportGroupUsers(List<User> supportGroupUsers) {
		this.supportGroupUsers = supportGroupUsers;
	}

	public Addiction getAddict() {
		return addict;
	}

	public void setAddict(Addiction addict) {
		this.addict = addict;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

	@Override
	public String toString() {
		return "\nSupportGroup [supportGroupId=" + supportGroupId + ", supportGroupName=" + supportGroupName
				+ ", \nsupportGroupUsers=" + supportGroupUsers + ", addict=" + addict + ", \npostList=" + postList
				+ ", \nreplyList=" + replyList + "]";
	}
	
}
