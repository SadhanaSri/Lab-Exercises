package day11;

import java.io.IOException;

public class Program2 {
	
	public void meth1() {
		meth2();
		System.out.println("caller");
	}
	
	public void meth2() {
		try {
			throw new IOException();   
		} catch(Throwable e) {
			System.out.println("catch meth2");
		} finally {
			System.out.println("finally meth2");
		}
	}

	public static void main(String[] args) {
		Program2 obj = new Program2();
		obj.meth1();

	}

}

