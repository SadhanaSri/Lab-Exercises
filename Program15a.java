package day1;

public class Program15a {
	public static void main(String args[]) {
		Util15 obj = new Util15();
		obj.generatePrimeNumbers();
	}
}

class Util15 {
	void generatePrimeNumbers() {
		int count;
		
		for(int i=1; i<=100; i++) {
			count=0;
			
			for(int num=i; num>=1; num--) 
				if(i%num == 0)
					count+=1;
			
			if(count == 2) 
				System.out.print(i+" ");
		}
	}
}
