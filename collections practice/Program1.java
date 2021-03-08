package collections_practise;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Program1 {
	public static class PhoneBookComparator implements Comparator<PhoneBookEntry> {
		@Override
		public int compare(PhoneBookEntry o1, PhoneBookEntry o2) {
			return o2.name.compareToIgnoreCase(o1.name);
		}
	}
	
	public static void main(String[] args) {
		PhoneBookEntry addr1 = new PhoneBookEntry("a");
		PhoneBookEntry addr2 = new PhoneBookEntry("b");
		PhoneBookEntry addr3 = new PhoneBookEntry("c");
		PhoneBookEntry addr4 = new PhoneBookEntry("d");
		
		Comparator<PhoneBookEntry> comp = new PhoneBookComparator();
		TreeSet<PhoneBookEntry> set = new TreeSet<>(comp);
		set.add(addr1);
		set.add(addr2);
		set.add(addr3);
		set.add(addr4);
		
		System.out.println(set);
		Set<PhoneBookEntry> newSet = set.descendingSet();
		System.out.println(newSet);
		
	}
}

class PhoneBookEntry {
	public String name, address, phone;
	
	public PhoneBookEntry(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}