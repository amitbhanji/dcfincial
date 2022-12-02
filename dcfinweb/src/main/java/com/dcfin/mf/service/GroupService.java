package com.dcfin.mf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dcfin.mf.model.ServiceExecutable;

public class GroupService implements ServiceExecutable {

	public String execute(HttpServletRequest request, HttpServletResponse response, String uiActionName) {
		String returnUiAction = null;
		if(uiActionName.equals("createGroup")) {
			returnUiAction = uiActionName;
		}
		return returnUiAction;
	}
}
