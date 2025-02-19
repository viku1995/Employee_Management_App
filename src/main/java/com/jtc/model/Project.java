package com.jtc.model;

public class Project {
	
	private long projectid;
    private String projectname;
    private String projectstartDate;
    private String projectendDate;
    
	public Project() {
	}

	public Project(long projectid, String projectname, String projectstartDate, String projectendDate) {
		super();
		this.projectid = projectid;
		this.projectname = projectname;
		this.projectstartDate = projectstartDate;
		this.projectendDate = projectendDate;
	}

	public long getProjectid() {
		return projectid;
	}

	public void setProjectid(long projectid) {
		this.projectid = projectid;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getProjectstartDate() {
		return projectstartDate;
	}

	public void setProjectstartDate(String projectstartDate) {
		this.projectstartDate = projectstartDate;
	}

	public String getProjectendDate() {
		return projectendDate;
	}

	public void setProjectendDate(String projectendDate) {
		this.projectendDate = projectendDate;
	}

	
    

}
