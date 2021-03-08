package collections_practise;

import java.util.ArrayList;

public class Program5 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		System.out.println(list.contains(new String("one")));
		System.out.println(list.indexOf("two"));
		list.clear();
		System.out.println(list);
		System.out.println(list.get(1)); //indexoutofbounds
	}
}
