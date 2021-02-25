package inheritance;

public class Program1 {
	
	public static void main(String[] args) {
		int data=10;
		int a[] = new int[5];
		Integer var = new Integer(5);
		
		for(int i=0; i<5; i++)
			a[i] = i+1;
		
		Program1 obj = new Program1();
		System.out.println("Initial Value of int data: "+data);
		System.out.println("Initial Value of array: ");
		for(int i=0; i<5; i++)
			System.out.print(a[i]+" ");
		System.out.println("Initial value of Integer data: "+var);
		
		
		obj.method(data, a, var); 
		
		System.out.println("Value of int data after change: "+data);
		System.out.println("Value of array after change: "+data);
		System.out.println("Value of Integer data after change: "+var);
		
		for(int i=0; i<5; i++)
			System.out.print(a[i]+" ");
		
		
	}
		
	void method(int data, int a[], Integer var) {
		data = 20;
		var=10;
		for(int i=0; i<5; i++) {
			a[i] = i+2;
		}
	}
}
