package com.dcfin.idp.model;

public class Role {

	private int roleId;
	private String roleName;
	private String roleDescription;
	private String roleCreateDate;
	
	public Role(String roleName, String roleDescription, String roleCreateDate) {
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.roleCreateDate = roleCreateDate;
	}
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public String getRoleCreateDate() {
		return roleCreateDate;
	}
	public void setRoleCreateDate(String roleCreateDate) {
		this.roleCreateDate = roleCreateDate;
	}


}
