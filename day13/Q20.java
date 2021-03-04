package day13;

import java.util.LinkedHashSet;

public class Q20 {
	 public static void main(String[] args) { 
		 LinkedHashSet<Turtle> t = new LinkedHashSet<Turtle>(); 
		 t.add(new Turtle(1)); t.add(new Turtle(2)); t.add(new Turtle(1)); 
		 System.out.println(t.size()); 
	} 
}


class Turtle { 
	int size; 
	public Turtle(int s) { size = s; } 
	public boolean equals(Object o) { return (this.size == ((Turtle)o).size); } 
// insert code here 
	 public int hashCode() { return size/5; } //2
	 
//	 if hashcode is not declared, output is 3
} 
  