package collections_practise;

import java.util.ArrayList;
import java.util.ListIterator;

public class Program8 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("s");
		list.add("o");
		list.add("l");
		list.add("v");
		list.add("e");
		list.add("r");
		
		ListIterator<String> iter = list.listIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		while(iter.hasPrevious()) {
			System.out.println(iter.previous());
		}
	}
}
