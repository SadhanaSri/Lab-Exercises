package interface5_package2;
import interface5_package1.Interface1;

class Demo implements Interface1 {
	@Override
	public void method1() {
		System.out.println("Method 1");
	}
	@Override
	public void method2() {
		System.out.println("Method 2");
	}
	@Override
	public void method3() {
		System.out.println("Method 3");
	}
}
 public class Main {
	 public static void main(String[] args) {
			Demo obj = new Demo();
			obj.method1();
			obj.method2();
			obj.method3();
	 }
 }