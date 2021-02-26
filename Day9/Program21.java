package day9;

public class Program21 {
	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
		boolean c=a|b;
		boolean d=a&b;
		boolean e=a^b;
		boolean f=(!a&b)|(a&!b);
		boolean g=!a;
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
//		true
//		false
//		true
//		true
//		false

	}
}
