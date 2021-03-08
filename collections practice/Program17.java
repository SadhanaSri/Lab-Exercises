package collections_practise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Program17 {
	public static void main(String[] args) {
		Collection list = new ArrayList();
		int values[] = {9, 11, -4, 1, 13, 99, 1, 0};
		
		for(int i=0; i<values.length; i++) {
			list.add(new Integer(values[i]));
		}
		
		System.out.println("Before: "+list);
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			Integer ele = (Integer)iter.next();
			int val = ele.intValue();
			
			if(val<1 || val>10) {
				iter.remove();
			}
		}
		
		System.out.println("After: "+list);
	}
}
