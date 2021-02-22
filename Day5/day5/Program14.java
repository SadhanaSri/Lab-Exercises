package day5;

public class Program14 {

	public static void main(String[] args) {
//		Type mismatch: cannot convert from int to boolean
//		int i=0;
//		if(i) {
//			System.out.println("Hello");
//		}
		
//		No error
		boolean b=true;
		boolean b2=true;
		if(b==b2) {
		 System.out.println("So true");
		 } 
		
//		No error
		int i=1;
		int j=2;
		if(i==1|| j==2)
		 System.out.println("OK");
		
//		Invalid operator &|
//		int i=1;
//		int j=2;
//		if(i==1 &| j==2)
//		 System.out.println("OK"); 

	}

}
