package com.dcfin.idp.model;

public class GroupRole {

	private int groupRoleId;
	private String groupRoleDescription;
	private int groupRoleGroupId;
	private int groupRoleRoleId;
	private String groupRoleCreateDate;
	
	
	public GroupRole(String groupRoleDescription,String groupRoleCreateDate)
	{
		this.groupRoleDescription = groupRoleDescription;
		this.groupRoleCreateDate = groupRoleCreateDate;
	}


	public int getGroupRoleId() {
		return groupRoleId;
	}


	public void setGroupRoleId(int groupRoleId) {
		this.groupRoleId = groupRoleId;
	}


	public String getGroupRoleDescription() {
		return groupRoleDescription;
	}


	public void setGroupRoleDescription(String groupRoleDescription) {
		this.groupRoleDescription = groupRoleDescription;
	}


	public int getGroupRoleGroupId() {
		return groupRoleGroupId;
	}


	public void setGroupRoleGroupId(int groupRoleGroupId) {
		this.groupRoleGroupId = groupRoleGroupId;
	}


	public int getGroupRoleRoleId() {
		return groupRoleRoleId;
	}


	public void setGroupRoleRoleId(int groupRoleRoleId) {
		this.groupRoleRoleId = groupRoleRoleId;
	}


	public String getGroupRoleCreateDate() {
		return groupRoleCreateDate;
	}


	public void setGroupRoleCreateDate(String groupRoleCreateDate) {
		this.groupRoleCreateDate = groupRoleCreateDate;
	}
	
	
	
	
	
}
