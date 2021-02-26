package day9;
import java.util.Scanner;

public class Program29 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		boolean isVowel = false;
		
		switch(ch) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U': isVowel = true;
		}
		if(isVowel == true) 
			System.out.println(ch+" is a vowel");
		else
			System.out.println(ch+" is not a vowel");
	}
}
