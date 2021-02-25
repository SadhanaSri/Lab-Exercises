package inheritance;

public class Program2 {
	
	
	public static void main(String[] args) {
		Complex c1 = new Complex(2, 3);
		Complex c2 = new Complex(4, 5);
		Complex ans = Complex.sum(c1, c2);
	
		System.out.println(ans.real+"+"+ans.imag+"i");
	}
}


class Complex {
	int real, imag;
	
	public Complex(int real, int imag ) {
		this.real = real;
		this.imag = imag;
	}
	
	static public Complex sum(Complex c1, Complex c2) {
		Complex ans = new Complex(0, 0);
		ans.real = c1.real + c2.real;
		ans.imag = c1.real + c2.imag;
		
		return ans;
	}
}
