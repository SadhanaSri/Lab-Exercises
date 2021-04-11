package onetomany;

public class BackupEmployee {
	private int eid;
	private String empname;
	private int empsal;
	
	public BackupEmployee(int eid, String empname, int empsal) {
		super();
		this.eid = eid;
		this.empname = empname;
		this.empsal = empsal;
	}
	
	public BackupEmployee() {
		// TODO Auto-generated constructor stub
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int getEmpsal() {
		return empsal;
	}

	public void setEmpsal(int empsal) {
		this.empsal = empsal;
	}
}
