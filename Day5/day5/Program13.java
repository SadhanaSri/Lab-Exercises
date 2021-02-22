package day5;

public class Program13 {

	public static void main(String[] args) {
		int i=9;
		switch (i) {
		 default:
		 System.out.println("default");
		 case 0:
		 System.out.println("zero");
		 break;
		 case 1:
		 System.out.println("one");
		 case 2:
		 System.out.println("two");
//		 default:
//			 System.out.println("default");
		}
//		Output: default, zero
//		Prints "default" case as no matching case is found.
//		Since, no break after default, prints case 0
	}

}
