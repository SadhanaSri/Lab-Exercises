package day9;

public class Program47 {

	public static void main(String[] args) {
		Util obj = new Util();
		obj.add(22.5f, 10.5f);
		obj.add(10, 20);
		obj.add(12, 10f, 20);
		
	}
}

class Util {
	void add(int num1, int num2) {
		int ans = num1+num2;
		System.out.println("Addition of "+num1+" & "+num2+": "+ans);
	}
	
	void add(float num1, float num2) {
		float ans = num1+num2;
		System.out.println("Addition of "+num1+" & "+num2+": "+ans);
	}
	
	float add(int num1, float num2, int num3) {
		float ans = num1+num2+num3;
		System.out.println("Addition of "+num1+" & "+num2+" & "+num3+" : "+ans);
		return ans;
	}
}
