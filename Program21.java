package day1;
import java.util.Scanner;

public class Program21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		
		switch(month) {
			case 1:
				System.out.println("No. of days in January: 31");
				break;
			case 2:
				System.out.println("Enter the year: ");
				int year = sc.nextInt();
				if( (year%400==0) || (year%100 !=0) && (year%4==0) )
					System.out.println("No. of days in February: 29");
				break;
			case 3:
				System.out.println("No. of days in March: 31");
				break;
			case 4:
				System.out.println("No. of days in April: 30");
				break;
			case 5:
				System.out.println("No. of days in May: 31");
				break;
			case 6:
				System.out.println("No. of days in June: 30");
				break;
			case 7:
				System.out.println("No. of days in July: 31");
				break;
			case 8:
				System.out.println("No. of days in August: 31");
				break;
			case 9:
				System.out.println("No. of days in September: 30");
				break;
			case 10:
				System.out.println("No. of days in October: 31");
				break;
			case 11:
				System.out.println("No. of days in November: 30");
				break;
			case 12:
				System.out.println("No. of days in December: 31");
				break;
			default:
				System.out.println("Enter a valid month");
			sc.close();
		}
	}

}
