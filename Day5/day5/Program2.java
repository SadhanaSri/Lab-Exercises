package day5;

public class Program2 {

	public static void main(String[] arguments) {
		amethod(arguments);
	 }
	
//	Error - cant make static reference to void amethod.
	/* public void amethod(String[] arguments) {
		 System.out.println(arguments);
		 System.out.println(arguments[1]);
	 }*/
	 
	 public static void amethod(String[] arguments) {
		 System.out.println(arguments);
		 System.out.println(arguments[1]);
	 }

}
