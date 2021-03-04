package day13;

import java.util.SortedMap;
import java.util.TreeMap;

public class Q23 {
	public static void main(String[] args) { 
		TreeMap<String, String> myMap = new TreeMap<String, String>(); 
		myMap.put("a", "apple"); myMap.put("d", "date"); 
		myMap.put("f", "fig"); myMap.put("p", "pear"); 
		
		System.out.println("1st after mango: " + // sop 1 1st after mango: p
		myMap.higherKey("f"));  //returns the least key greater than f
		
		System.out.println("1st after mango: " + // sop 2 1st after mango: f
		myMap.ceilingKey("f")); //returns the least key greater than/ equal to f 

		System.out.println("1st after mango: " + // sop 3 1st after mango: f
		myMap.floorKey("f")); //returns the greatest key less than/equal to f 
		
		SortedMap<String, String> sub = new TreeMap<String, String>(); 
		
		sub = myMap.tailMap("f"); //portion of map whose keys greater/equal to given key 
							//f p
		System.out.println("1st after mango: " + // sop 4 1st after mango: f
		sub.firstKey()); //f
		
	} 
}
