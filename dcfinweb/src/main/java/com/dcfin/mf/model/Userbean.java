package com.dcfin.mf.model;

import java.util.ArrayList;

public class Userbean {

	private ArrayList<User> userlist = new ArrayList<User>();
	
	
	public ArrayList<User> getAllusers()
	{
		
		User userbean = new User();
		userbean.setUserId(1);
		userbean.setUserName("Ricky");
		userbean.setEmailId("ricky@gmaill.com");
		userbean.setUserRole("Accountant");
		
		User userbean1 = new User();
		userbean.setUserId(2);
		userbean.setUserName("Smith");
		userbean.setEmailId("smith@gmaill.com");
		userbean.setUserRole("Manager");
		
		userlist.add(userbean);
		userlist.add(userbean1);
		
		
		return userlist;
		
	}
	
}
