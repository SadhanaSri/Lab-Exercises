package day9;

public class Program17 {

	public static void main(String[] args) {
		int a=0;
		int b=5;
		int c=10;
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		System.out.println("c = "+c);
		System.out.println("a += (b+c) = " + (a += (b+c)));
		System.out.println("b -= a = "+ (b -= a));
		System.out.println("c *= b = "+ (c *= b));
		System.out.println("c /= b = "+ (c /= b));

	}

}
