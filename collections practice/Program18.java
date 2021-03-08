package collections_practise;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Program18 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(new Integer(2));
		list.add(new Integer(8));
		list.add(new Integer(5));	
		list.add(new Integer(1));
		Iterator iter = list.iterator();
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.reverseOrder();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
