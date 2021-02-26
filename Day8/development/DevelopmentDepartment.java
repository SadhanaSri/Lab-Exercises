package development;
import employee.Department;

public class DevelopmentDepartment extends Department {
	protected int basic2 = 3000;
	
	public int allocatePay() {
		return basic2;
	}
}
