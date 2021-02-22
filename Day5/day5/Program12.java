package day5;

public class Program12 {

	public static void main(String[] args) {
		int i=1;
		 switch (i) {
		 case 0:
		 System.out.println("zero");
		 break;
		 case 1:
		 System.out.println("one");
		 case 2:
		 System.out.println("two");
		 default:
		 System.out.println("default");
		 } 
//		 Prints "one,two,default" since no break statements are provided after each case.

	}

}
