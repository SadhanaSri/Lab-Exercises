package day1;

public class Program25 {
	public static void main(String args[]) {
		
	}
}

/*Error - Illegal modifier for the class Base. Only final, abstract, public is allowed
 *  Nested classes can be private
 *  Protected class member (method or variable) is just like package-private (default visibility), except that it also can be accessed from subclasses.
 *	Since there's no such concept as 'subpackage' or 'package-inheritance' in Java, declaring class protected or package-private would be the same thing.
*/

/*protected class Base {
	String Method() {
		return "Wow";
	}
}

class Derived {
	public void useD() {
		Base z = new Base();
		System.out.println("Base says "+z.Method());
	}
	
} */