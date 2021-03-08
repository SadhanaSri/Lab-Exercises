package collections_practise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.TreeSet;

public class Program19 {
	public static void main(String[] args) {
		HashSet set1 = new HashSet();
		addRange(set1, 1);
		System.out.println(set1);
		ArrayList list = new ArrayList();
		addRange(list, 2);
		System.out.println(list);
		TreeSet set = new TreeSet();
		addRange(set, 3);
		System.out.println(set);
		set1.removeAll(list);
		list.addAll(set);
		System.out.println(set1);
	}
	
	static void addRange(Collection col, int step) {
		for(int i=step; i<=12; i+=step) {
			col.add(new Integer(i));
		}
	}
}
