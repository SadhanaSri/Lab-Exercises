package day11;

public class Program5 {

	public static void main(String[] args) {
		Demo2 obj = new Demo2();
		
		try {
			obj.meth(-1);     //try and finally without catch - error
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Finally block");
		}

	}

}

class Demo2 {
	public void meth(int i) throws Exception {
		if(i<0)
			throw new CustomException();
		System.out.println("value..."+i);
	} 
}
