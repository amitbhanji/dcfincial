package com.dcfin.idp.model;
public class Action {

	private String className;
    private String name;
    private String successPath;
    private String failurePath;
    
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuccessPath() {
		return successPath;
	}
	public void setSuccessPath(String successPath) {
		this.successPath = successPath;
	}
	public String getFailurePath() {
		return failurePath;
	}
	public void setFailurePath(String failurePath) {
		this.failurePath = failurePath;
	}
}
