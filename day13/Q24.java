package day13;

import java.util.TreeSet;

public class Q24 {
	public static void main(String[] args) { 
		TreeSet<Integer> i = new TreeSet<Integer>(); 
		TreeSet<Dog> d = new TreeSet<Dog>(); 

		d.add(new Dog(1)); d.add(new Dog(2)); d.add(new Dog(1)); 
		i.add(1); i.add(2); i.add(1); 
		System.out.println(d.size() + " " + i.size()); 
	} 
}

class Dog { int size; Dog(int s) { size = s; } } 

//G. An exception is thrown at runtime 
//ClassCastException since Dog class has not implemented the Comparable interface