package inheritance;

public class Program10 {
	public static void main(String[] args) {
		C c = new C(); //invokes A1 constructor
	}
}

class A1 {
	A1() {
		System.out.println("Class A");
	}
}

class B1 {
	B1() {
		System.out.println("Class B");
	}
}

class C extends A1 {
	B1 b;
}
