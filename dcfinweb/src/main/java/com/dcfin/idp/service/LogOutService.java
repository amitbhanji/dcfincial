package com.dcfin.idp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dcfin.idp.model.ServiceExecutable;

public class LogOutService implements ServiceExecutable {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uiActionName) {
		// TODO Auto-generated method stub
		String returnUiAction = null;
		if(uiActionName.equals("doLogout"))
		{
			returnUiAction = uiActionName;
		}
		return returnUiAction;
	}

}
