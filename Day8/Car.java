import vehicle.FourWheeler;

class Car extends FourWheeler {
	@Override
	public void drive() {
		System.out.println("Driving a Car");
		
	}
	public static void main(String[] args) {
		FourWheeler car = new Car();
		car.drive();
	}
}


