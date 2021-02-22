package day5;

public class Program49 {
	public static void main(String argv[]){
		 int iRand;
//		 iRand = Math.random();
//		 Compile time error referring to a cast problem-returns double values  
		 iRand = (int)Math.random(); 
		 System.out.println(iRand);
	}
}
