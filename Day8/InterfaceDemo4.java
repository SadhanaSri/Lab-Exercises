package day8;

public class InterfaceDemo4 {
	public static void main(String[] args) {
		Child child=new Child();
		child.method1();
		child.method2();
		child.method3();
		child.method4();
		child.method5();
		child.method6();
		child.method7();
		child.childMethod1(child);
		child.childMethod2(child);
		child.childMethod3(child);
		child.childMethod4(child);
	}
}

interface Interface1 {
	void method1();
	void method2();
}

interface Interface2 {
	void method3();
	void method4();
}

interface Interface3 {
	void method5();
	void method6();
}

interface Interface extends Interface1,Interface2,Interface3 {
	void method7();
} 

class Parent {
	
}

class Child extends Parent implements Interface  {
	@Override
	public void method1() {
		System.out.println("Interface1 method1");
		
	}
	@Override
	public void method2() {
		System.out.println("Interface1 method2");
		
	}
	@Override
	public void method3() {
		System.out.println("Interface2 method3");
		
	}
	@Override
	public void method4() {
		System.out.println("Interface2 method4");
		
	}
	@Override
	public void method5() {
		System.out.println("Interface3 method5");
	}
	@Override
	public void method6() {
		System.out.println("Interface3 method6");
	}
	@Override
	public void method7() {
		System.out.println("Interface method7");
	}
	
	public void childMethod1(Interface1 i1)
	{
		System.out.println("Interface 1 object: "+i1);
	}
	public void childMethod2(Interface1 i2)
	{
		System.out.println("Interface 2 object: "+i2);
	}
	public void childMethod3(Interface1 i3)
	{
		System.out.println("Interface 3 object: "+i3);
	}
	public void childMethod4(Interface1 i4)
	{
		System.out.println("Interface 4 object: "+i4);
	}
}