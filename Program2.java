//Write a program to print default values of all primitive types
package day1;

public class Program2 {
	public static void main(String args[]) {
		Util d = new Util();
		d.printDefaultValue();
	}
}

class Util {
	static int var1;
	static double var2;
	static float var3;
	static String var4;
	static boolean var5;
	
	public void printDefaultValue( ) {
		System.out.println("Default value of int: "+var1);
		System.out.println("Default value of double: "+var2);
		System.out.println("Default value of float: "+var3);
		System.out.println("Default value of String: "+var4);
		System.out.println("Default value of bool: "+var5);
	}
}
