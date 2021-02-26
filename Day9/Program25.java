package day9;

public class Program25 {
	public static void main(String[] args) {
		int a=10;
		int b=20;
		int c=30;
		
		if(a>=b && a>=c) {
			System.out.println(a+" is the biggest.");
		}
		else if(b>=a && b>=c) {
			System.out.println(b+" is the biggest.");
		}
		else {
			System.out.println(c+" is the biggest.");
		}
	}
}
