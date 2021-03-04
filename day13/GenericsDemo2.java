package day13;

import java.util.ArrayList;

public class GenericsDemo2 {
	public static void main(String[] args) {		
//		Generic array types cannot be processed, so make them specific
//		ArrayList arrList = new ArrayList();
//		arrList.add("rohan");
//		arrList.add(22);
//		arrList.add(22.18f);

		 ArrayList<String> arrList=new ArrayList<>(); 
		 arrList.add("hello");
		 arrList.add("world");
		 
		 for(int i=0;i<arrList.size();i++) { 
			 String s=arrList.get(i);
			 System.out.println(s);
		 } 
	}
}
