package collections_practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program12 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		fillData(map);
		
		String strings[] = keysAsArrays(map);
		for(String s : strings) {
			System.out.println(s);
		}
		
		List<String> list = keysAsList(map);
		for(String s: list) {
			System.out.println(s);
		}
	}
	
	private static void fillData(Map<String, String> map) {
		map.put("Android", "mobile");
		map.put("Eclipse IDE", "Java");
		map.put("Eclipse RCP", "Java");
	}
	
	private static String[] keysAsArrays(Map<String, String> map) {
		return map.keySet().toArray(new String[map.keySet().size()]);
	}

	private static List<String> keysAsList(Map<String, String> map) {
		List<String> list = new ArrayList<String>(map.keySet());
		return list;
	}
}
