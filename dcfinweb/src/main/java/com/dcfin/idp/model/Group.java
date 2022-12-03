package com.dcfin.idp.model;

public class Group {

	private int groupId;
	private String groupDescription;
	private String groupCreateDate;

	public Group(String groupDescription, String groupCreateDate) {
		this.groupDescription = groupDescription;
		this.groupCreateDate = groupCreateDate;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public String getGroupCreateDate() {
		return groupCreateDate;
	}

	public void setGroupCreateDate(String groupCreateDate) {
		this.groupCreateDate = groupCreateDate;
	}

}
