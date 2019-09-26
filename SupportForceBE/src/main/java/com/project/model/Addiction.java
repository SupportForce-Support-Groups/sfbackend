package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addiction")
public class Addiction {

	@Id
	@Column(name="addiction_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addictionId;
	
	@Column(name="addiction_name")
	private String addictionName;

	public Addiction() {
		super();
	}
	
	public Addiction(String addictionName) {
		super();
		this.addictionName = addictionName;
	}

	public Addiction(int addictionId, String addictionName) {
		super();
		this.addictionId = addictionId;
		this.addictionName = addictionName;
	}

	public int getAddictionId() {
		return addictionId;
	}

	public void setAddictionId(int addictionId) {
		this.addictionId = addictionId;
	}

	public String getAddictionName() {
		return addictionName;
	}

	public void setAddictionName(String addictionName) {
		this.addictionName = addictionName;
	}

	@Override
	public String toString() {
		return "\nAddiction [addictionId=" + addictionId + ", addictionName=" + addictionName + "]";
	}
	
}
