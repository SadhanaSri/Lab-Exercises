package day9;

public class Program48 {
	public static void main(String[] args) {
		Util2 obj1 = new Util2(22.5f, 10.5f);
		Util2 obj2 = new Util2(10, 20);
		Util2 obj3 = new Util2(12, 10f, 20);
	}
}

class Util2 {
	public Util2(int num1, int num2) {
		int ans = num1+num2;
		System.out.println("Addition of "+num1+" & "+num2+": "+ans);
	}
	
	public Util2(float num1, float num2) {
		float ans = num1+num2;
		System.out.println("Addition of "+num1+" & "+num2+": "+ans);
	}
	
	public Util2(int num1, float num2, int num3) {
		float ans = num1+num2+num3;
		System.out.println("Addition of "+num1+" & "+num2+" & "+num3+" : "+ans);
	}
}
