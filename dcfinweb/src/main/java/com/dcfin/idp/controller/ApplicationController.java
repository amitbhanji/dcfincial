package com.dcfin.idp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dcfin.idp.arch.ApplicationConfigurator;
import com.dcfin.idp.constants.ApplicationConstants;
import com.dcfin.idp.model.Action;
import com.dcfin.idp.model.ServiceExecutable;
import com.dcfin.idp.model.User;
import com.dcfin.idp.model.Userbean;

/**
 * Servlet implementation class ApplicationController
 */
public class ApplicationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map appConfig = null;
	private List<User> arraylist = null;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		InputStream appConfigStream = null;
		System.out.println("---- Loading Action Class Mapping ----");
		try {
			super.init(config);
			ApplicationConstants.loadConstants();
			String appConfigPath = ApplicationConstants.APP_CONFIG_XML_PATH;
			appConfigStream = config.getServletContext().getResourceAsStream(appConfigPath);
			appConfig = ApplicationConfigurator.buildActionClassMapping(appConfigStream);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
try {
			
			Userbean userbean = new Userbean();
		//	User u = new User();
		//	arraylist = userbean.getAllusers();
		//	String a = u.getUserName();
		//	int i = u.getUserId();
			//PrintWriter p = response.getWriter();
			//System.out.println(a);
			 resp.setContentType("text/html");
		//	req.setAttribute("name",a);
		
			String destination = "users.jsp";
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(destination);
			requestDispatcher.forward(req,resp);
		}
		catch(Exception e)
		{
			
		}
		
		
	}
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
		getresponse(request,response);
		//doGet(request, response);
	}

	private List<User> getresponse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
	
		try {
			
			Userbean userbean = new Userbean();
		
			arraylist = userbean.getAllusers();
			for(User u:arraylist)
			{PrintWriter p = response.getWriter();
			  p.write(u.getUserId());
			 // p.write(u.getUserName());
			}
			
			
		}
		catch(Exception e)
		{
			
		}
		return arraylist;
		
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uiActionName = null;
		Action action = null;

		System.out.println("Current action name::" + request.getParameter("uiActionName"));
		if (request.getParameter("uiActionName") != null) {
			uiActionName = request.getParameter("uiActionName");
		} else {
			uiActionName = "validateLogin";
		}

		System.out.println("********INSIDE PROCESS METHOD********** uiActionName is" + uiActionName);
		try {
			action = (Action) appConfig.get(uiActionName);

			String serviceClassName = action.getClassName();
			System.out.println("Current Class Name:: === " + serviceClassName);

			Class cls = Class.forName(serviceClassName);

			ServiceExecutable executable = (ServiceExecutable) cls.newInstance();

			String executedAction = executable.execute(request, response, uiActionName);

			if (executedAction != null && executedAction.length() > 0) {
				uiActionName = executedAction;
			}
			System.out.println("After execute method ....... uiActionName name is " + uiActionName);
			action = (Action) appConfig.get(uiActionName);
			String successPath = action.getSuccessPath();
			System.out.println("successPath === " + successPath);
			try {
				forwardRequest(request, response, successPath);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			uiActionName = null;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void forwardRequest(HttpServletRequest request, HttpServletResponse response, String successPath)
			throws Exception {
		try {
			RequestDispatcher rdObj = request.getRequestDispatcher(successPath);
			rdObj.forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
