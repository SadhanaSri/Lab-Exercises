package day1;

public class Program27 {

	public static void main(String[] args) {
		int principal = 14000;
		float first_year = (float)(14000+(14000*0.40));
		float second_year = first_year-1500;
		float third_year = (float)(second_year+(second_year*0.12));
		System.out.println("Worth of the investment: "+third_year);
	}

}
