package collections_practise;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Program14 {
	public static void main(String[] args) {
		Map map = new HashMap();
		Integer one = new Integer(1);
		
		for(int i=0, n=args.length; i<n; i++) {
			String key = args[i];
			Integer freq = (Integer)map.get(key);
			
			if(freq == null) {
				freq = one;
			} else {
				int val = freq.intValue();
				freq = new Integer(val+1);
			}
			
			map.put(key, freq);
		}
		System.out.println(map);
		Map sortedMap =  new TreeMap(map);
		System.out.println(sortedMap);
	}
}
