package employee;

public class Employee {
	String name;
	String department;
	String role;
	int salary;

	public Employee(String name, String department, String role) {
		this.setName(name);
		this.setDepartment(department);
		this.setRole(role);
	}
	
	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", role=" + role + ", salary=" + salary + "]";
	}
	
	
}
