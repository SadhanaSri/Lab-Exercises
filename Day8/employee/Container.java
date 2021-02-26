package employee;

public class Container {
	public static void getDepartment(String departmentName, Employee employee) throws Exception {
		Department department = (Department)Class.forName(departmentName).newInstance();
		int salary = department.allocatePay();
		employee.setSalary(salary);
	} 
}
