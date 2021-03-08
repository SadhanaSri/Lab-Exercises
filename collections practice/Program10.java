package collections_practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program10 {
	public static void main(String[] args) {
		List<String> list = createList();
		list.removeIf(ele -> ele.toLowerCase().contains("b"));
		list.forEach(ele -> System.out.println(ele));
	}
	
	private static List<String> createList() {
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("A", "B", "C", "D"));
		return list;
	}
}
