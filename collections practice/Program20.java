package collections_practise;

import java.util.List;
import java.util.Arrays;

public class Program20 {
	public static void main(String[] args) {
		String str[] = {"alpha", "beta", "charlie"};
		System.out.println(Arrays.toString(str));
		List<String> list = Arrays.asList(str);
		
		str[0] += "88";
		list.set(2, list.get(2)+"99");
		System.out.println(Arrays.toString(str));
		System.out.println(list);
		
		List<Integer> list2 = Arrays.asList(22, 44, 11, 33);
		System.out.println(list2);
	}
}
