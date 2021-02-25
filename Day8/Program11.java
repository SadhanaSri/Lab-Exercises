package inheritance;

public class Program11 {
	public static void main(String[] args) {
		C2 c = new C2(); 
	}
}

class A2 {
	public A2() {
	}
	A2(int i) {
		System.out.println("Class A2");
	}
}

class B2 {
	B2(int i) {
		System.out.println("Class B2");
	}
}

class C2 extends A2 {
	public C2() {
		System.out.println("Class C2");
		B2 b = new B2(10);
		A2 a = new A2(20);
	}
}
