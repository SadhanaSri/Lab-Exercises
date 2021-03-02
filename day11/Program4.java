package day11;

public class Program4 {
	public static void main(String[] args) {
		try {
			Program4 obj = new Program4();
			obj.meth(-1);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Finally block");
		}
	}
	
	public void meth(int i) throws Exception {
		if(i < 0)
			throw new CustomException();
		System.out.println("Value: "+i);
	}
}

class CustomException extends Exception {
	public CustomException() {
		System.out.println("Exception...value less than 0....");
	}
}
