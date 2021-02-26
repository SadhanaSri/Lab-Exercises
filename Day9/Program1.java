package day9;

public class Program1 {

	public static void main(String[] args) {
		  int a, b; 
		  a = 10; 
		  b = 20; 
		  
		  System.out.println("Before swapping : a, b = "+a+", "+ + b); 
		  
		  a = a + b; 
		  b = a - b; 
		  a = a - b; 
		  
		  System.out.println("After swapping : a, b = "+a+", "+ + b); 

	}

}
