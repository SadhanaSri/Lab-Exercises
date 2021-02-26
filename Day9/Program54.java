package day9;

public class Program54 {

	public static void main(String[] args) {
		Interface ref;
		System.out.println(Interface.i);
//		Error: static field i d=should be accessed in a static way
//		System.out.println(ref.i); 
	}

}

interface Interface {
	int i=10; //static by default
}


