package annotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_DETAILS")
public class Employee {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="NAME", nullable = false)
	private String name;
	
	@Column(name="JOININGDATE", nullable = false)
	private LocalDate joiningDate;
	
	@Column(name = "JOININGTIME", nullable = false)
	private LocalTime joiningTime;
	
	@Column(name = "JOININGDATETIME", nullable = false)
	private LocalDateTime joiningDateTime;

	@Column(name="SALARY", nullable = false)
	private BigDecimal salary;
	
	@Column(name = "SSN", unique=true, nullable = false)
	private String ssn;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int id, String name, LocalDate joiningDate, LocalTime joiningTime, LocalDateTime joiningDateTime,
			BigDecimal salary, String ssn) {
		super();
		this.id = id;
		this.name = name;
		this.joiningDate = joiningDate;
		this.joiningTime = joiningTime;
		this.joiningDateTime = joiningDateTime;
		this.salary = salary;
		this.ssn = ssn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public LocalTime getJoiningTime() {
		return joiningTime;
	}

	public void setJoiningTime(LocalTime joiningTime) {
		this.joiningTime = joiningTime;
	}

	public LocalDateTime getJoiningDateTime() {
		return joiningDateTime;
	}

	public void setJoiningDateTime(LocalDateTime joiningDateTime) {
		this.joiningDateTime = joiningDateTime;
	}
	
	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((joiningDate == null) ? 0 : joiningDate.hashCode());
		result = prime * result + ((joiningDateTime == null) ? 0 : joiningDateTime.hashCode());
		result = prime * result + ((joiningTime == null) ? 0 : joiningTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (joiningDate == null) {
			if (other.joiningDate != null)
				return false;
		} else if (!joiningDate.equals(other.joiningDate))
			return false;
		if (joiningDateTime == null) {
			if (other.joiningDateTime != null)
				return false;
		} else if (!joiningDateTime.equals(other.joiningDateTime))
			return false;
		if (joiningTime == null) {
			if (other.joiningTime != null)
				return false;
		} else if (!joiningTime.equals(other.joiningTime))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", joiningDate=" + joiningDate + ", joiningTime=" + joiningTime
				+ ", joiningDateTime=" + joiningDateTime + ", salary=" + salary + ", ssn=" + ssn + "]";
	}
}
