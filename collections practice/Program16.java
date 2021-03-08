package collections_practise;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Program16 {
	public static void main(String[] args) {
		List list = new ArrayList();
		Random random = new Random();
		for(int i=3; i<=5; i++) {
			list.add(new Integer(random.nextInt(2)));
		}
		System.out.println(list);
		
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			int i = ((Integer)iter.next()).intValue();
			System.out.println(i);
		}
	}
}
