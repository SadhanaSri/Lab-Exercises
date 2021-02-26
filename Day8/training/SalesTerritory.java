package training;

public class SalesTerritory extends TrainingDepartment {
	@Override
	public int allocatePay() {
		return basic+3000;
	}
}
