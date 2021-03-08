package collections_practise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Program3 {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");
		
		Iterator iter = map.entrySet().iterator();
		
		while(iter.hasNext()) {
			Map.Entry e = (Map.Entry)iter.next();
			System.out.println("Key: "+e.getKey()+" Value: "+e.getValue());
		}
	}
}
