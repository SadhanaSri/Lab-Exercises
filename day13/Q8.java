package day13;

import java.util.List;

public class Q8 {
	public static void main(String[] args) {
		
	}
	
	public static <E extends Number> List<E> process(List<E> nums)  {
//		Option F
		List<Integer> input = null; List<Integer> output = null; 
		output = process(input);
		return nums; 
	}
}
