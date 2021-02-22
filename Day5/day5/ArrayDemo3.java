package day5;

public class ArrayDemo3 {

	public static void main(String[] args) {
		char c[] = {'a', 'b', 'c'};
		System.out.println("Initial value :"+c[0]);
		//char ccopy[]=c;
		 char ccopy[]=new char[3];
		 System.arraycopy(c, 0, ccopy, 0, c.length);
		 acceptArray(ccopy);

		 System.out.println("After passing array..:"+c[0]); 
	}

	public static void acceptArray(char cc[]) {
	 cc[0]='z';
	 } 
}

