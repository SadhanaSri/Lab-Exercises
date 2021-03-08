package collections_practise;

import java.util.HashMap;
import java.util.Map;

public class Program13 {
	public static void main(String[] args) {
		Map<String, Integer> map = createMap();
		
		map.keySet().forEach(key->System.out.println(key+" "+map.get(key)));
	}
	
	private static Map<String, Integer> createMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Eclipse IDE", 0);
		map.put("Eclipse RCP", 0);
		map.put("GIT", 0);
		return map;
	}
}
