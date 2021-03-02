package day11;

//Exception in base class constructor cannot be caught in the derived class constructor
public class Program6 {
	public static void main(String[] args) throws Exception {
		try {
			Derived d = new Derived();
		} finally {
			System.out.println("Exception handled in main");
		} 
	}
}

class Base {
	public Base() throws Exception {
		throw new CustomException2();
	}
}

class Derived extends Base {
	public Derived() throws Exception {
	}
}

class CustomException2 extends Exception {
	public CustomException2() {
		System.out.println("Exception from base class.");
	}
}
