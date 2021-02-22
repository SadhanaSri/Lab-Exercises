package day1;

public class Program23 {
	protected int pro;
		
	public static void main(String args[]) {
		SubClass obj = new SubClass();
		obj.method();
	}
	
}

class SubClass extends Program23 {
	public void method() {
		System.out.println(pro);
	}
} 


