package com.jtc.model;

public class ContactPerson {
	
	  	private long cpid;
	    private String cpname;
	    private String cpemail;
	    private String cpphone;
	    private String cpdesignation;
	    
		public ContactPerson() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ContactPerson(long cpid, String cpname, String cpemail, String cpphone, String cpdesignation) {
			super();
			this.cpid = cpid;
			this.cpname = cpname;
			this.cpemail = cpemail;
			this.cpphone = cpphone;
			this.cpdesignation = cpdesignation;
		}

		public long getCpid() {
			return cpid;
		}

		public void setCpid(long cpid) {
			this.cpid = cpid;
		}

		public String getCpname() {
			return cpname;
		}

		public void setCpname(String cpname) {
			this.cpname = cpname;
		}

		public String getCpemail() {
			return cpemail;
		}

		public void setCpemail(String cpemail) {
			this.cpemail = cpemail;
		}

		public String getCpphone() {
			return cpphone;
		}

		public void setCpphone(String cpphone) {
			this.cpphone = cpphone;
		}

		public String getCpdesignation() {
			return cpdesignation;
		}

		public void setCpdesignation(String cpdesignation) {
			this.cpdesignation = cpdesignation;
		}

}
