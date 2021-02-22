package package1;

public class StaticDemo {
	public static void main(String args[]) {
		Connection con = Connection.getConnection();
		Connection.someMethod1(); //static methods are called using their class name
		Connection.someMethod2();
	}
}

class Connection {
	private Connection() {
		System.out.println("Constructor of connection");
	}
//   static block is a replacement for constructor especially for static methods.
//	 used for static initializations of a class
	static {
		System.out.println("static block called");
	}
	
	public static Connection getConnection() {
		return new Connection(); // factory methods - creating object using method since the class has a private constructor
	}
	
	public static void someMethod1() {
		System.out.println("some logic 1");
	}
	
	public static void someMethod2() {
		System.out.println("some logic 2");
	}
}
