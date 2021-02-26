package day9;

public class Program18 {
	public static void main(String[] args) {
		int a = 1; 
	    int b = 2; 
	    int c; 
	    int d; 
	    
	    c = ++b; //3
	    d = a++; //3
	    c++; //4
	    
	    System.out.println("c = "+c); //4
	    System.out.println("d = "+d); //1
	}
}
