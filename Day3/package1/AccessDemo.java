package package1;

public class AccessDemo {
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
}

class SubClass1 extends AccessDemo {
	public void method2() {
//		System.out.println(pri);
		System.out.println(pro);
		System.out.println(nomod);
		System.out.println(pub);
	}
} 

class NonSubClass {
	public void method3() {
		AccessDemo demo = new AccessDemo();
//		System.out.println(demo.pri);
		System.out.println(demo.pro);
		System.out.println(demo.nomod);
		System.out.println(demo.pub);
	}
}
