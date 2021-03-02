package day11;

import java.io.IOException;

public class Program1 {

	public static void main(String[] args) {
		Test obj = new Test();
		obj.method();
	}
}

class Test {
//	void method() throws IOException {
//		throw new IOException(); //compilation error - unhandled exception
//	}
//	add throws keyword to denote that it throws an exception or use a try catch to handlethe termination

//	Method 1
//	void method() throws IOException {
//		throw new IOException();  
//	}
	
//	Method 2
	void method() {
		try {
			throw new IOException();
		} catch(Exception e) {
			
		}
	}
}
