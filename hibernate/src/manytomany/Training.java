package manytomany;

import java.time.LocalDate;
import java.util.Set;

public class Training{
	private int tid;
	private String tname;
	private LocalDate tstartdate;
	private Set<Student> students;

	public Training() {
		// TODO Auto-generated constructor stub
	}
	
	public Training(int tid, String tname, LocalDate tstartdate, Set<Student> students) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tstartdate = tstartdate;
		this.students = students;
	}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public LocalDate getTstartdate() {
		return tstartdate;
	}
	public void setTstartdate(LocalDate tstartdate) {
		this.tstartdate = tstartdate;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Training [tid=" + tid + ", tname=" + tname + ", tstartDate=" + tstartdate + ", students=" + students
				+ "]";
	}
}
