package day1;

public class Program3 {
	public static void main(String args[]) {
		//implicit type casting - automatic type conversion
		byte i = 40;
	    short j = i;
	    int k = j;
	    long l = k;
	    float m = l;
	    double n = m;
		
		System.out.println("byte value : "+i);
	    System.out.println("short value : "+j);
	    System.out.println("int value : "+k);
	    System.out.println("long value : "+l);
	    System.out.println("float value : "+m);
	    System.out.println("double value : "+n);

	
		
//	char ch = 88; incompatible types
	
	//explicit type casting
	    double d = 30.0;
	      // Explicit casting is needed for below conversion
	      float f = (float) d;
	      long l1 = (long) f;
	      int num = (int) l;
	      short s = (short) num;
	      byte b = (byte) s;
	      System.out.println("double value : "+d);
	      System.out.println("float value : "+f);
	      System.out.println("long value : "+l1);
	      System.out.println("int value : "+num);
	      System.out.println("short value : "+s);
	      System.out.println("byte value : "+b);
	}
}
