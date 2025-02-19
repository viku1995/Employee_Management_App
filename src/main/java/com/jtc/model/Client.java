package com.jtc.model;

public class Client {
	
		private long clientid;
	    private String clientname;
	    private String clientrelationshipDate;
	    
		public Client() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Client(long clientid, String clientname, String clientrelationshipDate) {
			super();
			this.clientid = clientid;
			this.clientname = clientname;
			this.clientrelationshipDate = clientrelationshipDate;
		}

		public long getClientid() {
			return clientid;
		}

		public void setClientid(long clientid) {
			this.clientid = clientid;
		}

		public String getClientname() {
			return clientname;
		}

		public void setClientname(String clientname) {
			this.clientname = clientname;
		}

		public String getClientrelationshipDate() {
			return clientrelationshipDate;
		}

		public void setClientrelationshipDate(String clientrelationshipDate) {
			this.clientrelationshipDate = clientrelationshipDate;
		}
   

}
