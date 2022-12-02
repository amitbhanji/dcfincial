package com.dcfin.idp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dcfin.idp.model.ServiceExecutable;

public class RoleService implements ServiceExecutable{
	public String execute(HttpServletRequest request, HttpServletResponse response, String uiActionName) {
		String returnUiAction = null;
		if(uiActionName.equals("createRole")) {
			returnUiAction = uiActionName;
		}
		return returnUiAction;
	}
}
