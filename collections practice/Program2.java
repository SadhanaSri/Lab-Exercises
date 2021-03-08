package collections_practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program2 {
	public static void main(String[] args) {
		List<String> list = getList();
		list.removeIf(ele->ele.toLowerCase().contains("er"));
		list.forEach(ele->System.out.println(ele));
	}
	
	private static List<String> getList() {
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("lion", "tiger", "elephant", "cheetah"));
		return list;
	}
}
