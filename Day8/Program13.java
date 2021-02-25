package inheritance;

public class Program13 {
	public static void main(String args[]) {
//		Test test = new Test(); cannot instantiate abstract class
		Test.method();
	}
}

abstract class Test {
	public static void method() {
		System.out.println("Method 1");
	}
}
