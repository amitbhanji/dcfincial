package com.dcfin.mf.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ServiceExecutable {
	String execute(HttpServletRequest request, HttpServletResponse response, String uiActionName);
}
