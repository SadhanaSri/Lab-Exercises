package collections_practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Program21 {
	public static void main(String[] args) {
		String array[] = {"hi", "hello", "HI", "Hello"};
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
		System.out.println(Arrays.binarySearch(array, "hello"));
		System.out.println(Arrays.binarySearch(array, "Hello"));
		
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(22);
		list.add(11);
		list.add(44);
		list.add(33);
		
		Collections.sort(list);
		System.out.println(list);
		System.out.println(Collections.binarySearch(list, 22));
		System.out.println(Collections.binarySearch(list, 35));
	}
}
