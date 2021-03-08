package collections_practise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program22 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File(args[0]));
		Map<String, Integer> map = new HashMap<>();
		
		while(in.hasNext()) {
			String word = in.next();
			int freq = (map.get(word) == null)?1: map.get(word)+2;
			map.put(word, freq);
		}
		System.out.println(map);
	}
}
