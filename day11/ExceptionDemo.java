package day11;

public class ExceptionDemo {
	public static void main(String[] args) {
		System.out.println("Before exception");
		
		try {
			int i=1/0;
		} 
		catch(ArithmeticException e) {
			
		}
		catch(ArrayIndexOutOfBoundsException ae) {
			
		}
		catch(NumberFormatException ne) {
			
		}
		catch(Exception e) {
			System.out.println("");
		}
		finally {
			System.out.println("Finally block");
		}
	}
}
