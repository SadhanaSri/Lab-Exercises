package day1;

public class Program17c {
	int var1;
	
	public Program17c(int var1) {
		this.var1 = var1; 
	}
	
	public static void main(String args[]) {
//		Program17c obj = new Program17c();  Error: The constructor is undefined
		Program17c obj = new Program17c(2);  
	}
}
