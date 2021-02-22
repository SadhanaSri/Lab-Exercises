package package2;

import package1.AccessDemo;

public class Test extends AccessDemo {
	public void method4() {
//		System.out.println(pri);
		System.out.println(pro);
//		System.out.println(nomod);
		System.out.println(pub);
	}
}

class NonSubClass2 {
	public void method5() {
		AccessDemo demo = new AccessDemo();
//		System.out.println(demo.pri);
//		System.out.println(demo.pro);
//		System.out.println(demo.nomod);
		System.out.println(demo.pub);
	}
}
