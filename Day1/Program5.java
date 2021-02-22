package day1;
import java.util.Scanner;

public class Program5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		Util5 obj = new Util5();
		System.out.println("Average of "+n+" numbers is "+obj.printAverage(n));
	}

}

class Util5 {
	float printAverage(int n) {
		int sum=0;
		float avg=0;
		
		for(int i=1; i<=n; i++)
			sum+=i;
		
		avg=sum/n;
		return avg;
	}
}
