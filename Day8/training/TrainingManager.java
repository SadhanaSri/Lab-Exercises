package training;

public class TrainingManager extends TrainingDepartment {
	@Override
	public int allocatePay() {
		return basic+10000;
	}
}
