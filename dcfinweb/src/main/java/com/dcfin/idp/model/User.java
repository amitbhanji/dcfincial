package com.dcfin.idp.model;



public class User {

	private int userId;
	private String userUname;
	private String userEmail;
	private String userFname;
	private String userMname;
	private String userLname;
	private String userAddress;
	private String userCreateTime;
	private String userCreateBy;
	private String userUpdateTime;
	private String userUpdateBy;
	private String userDeleteTime;
	private String userDeleteBy;
	private boolean userIsActive;
	
	public User(String userUname,String userEmail,String userCreateTime)
	{
		this.userUname = userUname;
		this.userEmail = userEmail;
		this.userCreateTime = userCreateTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserUname() {
		return userUname;
	}

	public void setUserUname(String userUname) {
		this.userUname = userUname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserMname() {
		return userMname;
	}

	public void setUserMname(String userMname) {
		this.userMname = userMname;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(String userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public String getUserCreateBy() {
		return userCreateBy;
	}

	public void setUserCreateBy(String userCreateBy) {
		this.userCreateBy = userCreateBy;
	}

	public String getUserUpdateTime() {
		return userUpdateTime;
	}

	public void setUserUpdateTime(String userUpdateTime) {
		this.userUpdateTime = userUpdateTime;
	}

	public String getUserUpdateBy() {
		return userUpdateBy;
	}

	public void setUserUpdateBy(String userUpdateBy) {
		this.userUpdateBy = userUpdateBy;
	}

	public String getUserDeleteTime() {
		return userDeleteTime;
	}

	public void setUserDeleteTime(String userDeleteTime) {
		this.userDeleteTime = userDeleteTime;
	}

	public String getUserDeleteBy() {
		return userDeleteBy;
	}

	public void setUserDeleteBy(String userDeleteBy) {
		this.userDeleteBy = userDeleteBy;
	}

	public boolean isUserIsActive() {
		return userIsActive;
	}

	public void setUserIsActive(boolean userIsActive) {
		this.userIsActive = userIsActive;
	}


	
}
