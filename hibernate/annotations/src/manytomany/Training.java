package manytomany;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Training {
	@Id 
	private int tid;
	private String tname;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinTable(name="Employee_has_training")
	private Collection<Employee> employee;
	
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
	public Collection<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(Collection<Employee> employee) {
		this.employee = employee;
	}
}
