package manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="employee")
@Table(name="employee")
public class Employee {
	@Id
	private int eid;
	private String ename;
	private int esal;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="employee")
	private Set<Address> addresses = new HashSet<Address>(0);
	
	@ManyToMany(cascade= {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(name="Employee_has_training")
	private Set<Training> trainings = new HashSet<Training>(0);
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEsal() {
		return esal;
	}
	public void setEsal(int esal) {
		this.esal = esal;
	}
	public Set<Training> getTrainings() {
		return trainings;
	}
	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}	
}
