package day11;

public class Program3 {
	
	public void meth1() {
		meth2();
		System.out.println("caller");
	}
	
	public void meth2() {
		try {
			System.exit(0);   //program gets terminated
		} catch(Throwable e) {
			System.out.println("catch meth2");
		} finally {
			System.out.println("finally meth2"); //doesn't get executed
		}
	}

	public static void main(String[] args) {
		Program3 obj = new Program3();
		obj.meth1();
	}

}

