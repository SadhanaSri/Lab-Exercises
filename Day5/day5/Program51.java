package day5;

public class Program51 {
//	private int i;
	private static int i; //correct statement
	public static void main(String argv[]){
		Program51 s = new Program51();
		s.amethod();
	}
	
	public static void amethod(){
		System.out.println(i);
	}
	
//	 A compile time error complaining of the scope of the variable i
//	Cannot make a static reference to the non-static variable i
}
