package soapdemo;

public class EmployeeDTO {
		private int eid;
		private String ename;
		private int esal;	
		public EmployeeDTO() {
			// TODO Auto-generated constructor stub
		}
		
		
		@Override
		public String toString() {
			return "EmployeeDTO [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
		}


		public EmployeeDTO(int eid, String ename, int esal) {
			this.eid = eid;
			this.ename = ename;
			this.esal = esal;
		}
		public final int getEid() {
			return eid;
		}
		public final void setEid(int eid) {
			this.eid = eid;
		}
		public final String getEname() {
			return ename;
		}
		public final void setEname(String ename) {
			this.ename = ename;
		}
		public final int getEsal() {
			return esal;
		}
		public final void setEsal(int esal) {
			this.esal = esal;
		}
	}