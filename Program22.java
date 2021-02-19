package day1;

public class Program22 {
	private int pri;
	protected int pro;
	int nomod;
	public int pub;
	
	public void method1() {
		System.out.println(pri);
		System.out.println(pro);
		System.out.println(nomod);
		System.out.println(pub);
	}
	
	public static void main(String args[]) {
		Program22 obj = new Program22();
		obj.method1();
		
		SubClass1 obj2 = new SubClass1();
		obj2.method2();
		
		NonSubClass obj3 = new NonSubClass();
		obj3.method3();
	}
	
}

class SubClass1 extends Program22 {
	public void method2() {
//		System.out.println(pri); Error - Program22.pri is not visible
		System.out.println(pro);
		System.out.println(nomod);
		System.out.println(pub);
	}
} 

class NonSubClass {
	public void method3() {
		Program22 demo = new Program22();
//		System.out.println(demo.pri); Program22.pri is not visible
		System.out.println(demo.pro);
		System.out.println(demo.nomod);
		System.out.println(demo.pub);
	}
}
