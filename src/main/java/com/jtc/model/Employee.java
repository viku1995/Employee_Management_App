package com.jtc.model;

public class Employee {
	
		private long empid;
	    private String empname;
	    private String empdepartment;
	    private String empemail;
	    private String empphone;
	    private String empjoiningDate;
	    
		public Employee() {
			
		}

		
	
		public Employee(long empid, String empname, String empdepartment, String empemail, String empphone,
				String empjoiningDate) {
			this.empid = empid;
			this.empname = empname;
			this.empdepartment = empdepartment;
			this.empemail = empemail;
			this.empphone = empphone;
			this.empjoiningDate = empjoiningDate;
		}


		

		public Employee(String empname, String empdepartment, String empemail, String empphone, String empjoiningDate) {
			super();
			this.empname = empname;
			this.empdepartment = empdepartment;
			this.empemail = empemail;
			this.empphone = empphone;
			this.empjoiningDate = empjoiningDate;
		}



		public long getEmpid() {
			return empid;
		}

		public void setEmpid(long empid) {
			this.empid = empid;
		}

		public String getEmpname() {
			return empname;
		}

		public void setEmpname(String empname) {
			this.empname = empname;
		}

		public String getEmpdepartment() {
			return empdepartment;
		}

		public void setEmpdepartment(String empdepartment) {
			this.empdepartment = empdepartment;
		}

		public String getEmpemail() {
			return empemail;
		}

		public void setEmpemail(String empemail) {
			this.empemail = empemail;
		}

		public String getEmpphone() {
			return empphone;
		}

		public void setEmpphone(String empphone) {
			this.empphone = empphone;
		}

		public String getEmpjoiningDate() {
			return empjoiningDate;
		}

		public void setEmpjoiningDate(String empjoiningDate) {
			this.empjoiningDate = empjoiningDate;
		}

		
}
