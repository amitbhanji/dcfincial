package com.dcfin.idp.model;

public class UserProfile {

	private int userProfileId;
	private String userProfileDescription;
	private String userProfileCreateDate;
	
	public UserProfile(String userProfileDescription,String userProfileCreateDate)
	{
		this.userProfileDescription = userProfileDescription;
		this.userProfileCreateDate = userProfileCreateDate;
	}

	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getUserProfileDescription() {
		return userProfileDescription;
	}

	public void setUserProfileDescription(String userProfileDescription) {
		this.userProfileDescription = userProfileDescription;
	}

	public String getUserProfileCreateDate() {
		return userProfileCreateDate;
	}

	public void setUserProfileCreateDate(String userProfileCreateDate) {
		this.userProfileCreateDate = userProfileCreateDate;
	}
	
	
	
}
