package training;
import employee.Department;

public class TrainingDepartment extends Department {
	protected int basic=5000;
	@Override
	public int allocatePay() {
		return basic;
	}
}
