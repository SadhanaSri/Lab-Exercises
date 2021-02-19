package day1;
import java.util.Scanner;

public class Program13 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int stud = sc.nextInt();
		int mark = sc.nextInt();
		int marks[][] = new int[stud][mark];
		
		for(int i=0; i<stud; i++)
			for(int j=0; j<mark; j++)
				marks[i][j] = sc.nextInt();
		
		Util13 obj = new Util13();
		obj.calculateResult(marks, stud, mark);
		sc.close();
		
	}
}

class Util13 {
	void calculateResult(int marks[][], int stud, int mark) {
		int sum;
		int avg;
		
		for(int i=0; i<stud; i++) {
			sum=0;
			avg=0;
			for(int j=0; j<mark; j++) {
				sum+=marks[i][j];
			}
			avg=sum/mark;
			System.out.println("Total Marks of Student "+(i+1)+": "+sum);
			System.out.println("Average of Student "+(i+1)+": "+avg);
		}
	}
}
