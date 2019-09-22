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
@Table(name = "support_group")
public class SupportGroup {
	
	@Id
	@Column(name = "support_group_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supportGroupId;
	
	@Column(name = "support_group_name", nullable = false)
	private String supportGroupName;
	
	@ManyToOne
	@JoinColumn(name = "addict", referencedColumnName = "addiction_id")
	private Addiction addict;
	
	public SupportGroup() {
		super();
	}
	
	public SupportGroup(String supportGroupName, Addiction addict) {
		super();
		this.supportGroupName = supportGroupName;
		this.addict = addict;
	}

	public SupportGroup(int supportGroupId, String supportGroupName, Addiction addict) {
		super();
		this.supportGroupId = supportGroupId;
		this.supportGroupName = supportGroupName;
		this.addict = addict;
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

	public Addiction getAddict() {
		return addict;
	}

	public void setAddict(Addiction addict) {
		this.addict = addict;
	}

	@Override
	public String toString() {
		return "SupportGroup [supportGroupId=" + supportGroupId + ", supportGroupName=" + supportGroupName + ", addict="
				+ addict + "]";
	}
	
}
