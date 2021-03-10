package day17;

import java.util.Locale;
import java.util.ResourceBundle;

public class InternationalizationDemo {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("ta"));
		Locale locale = Locale.getDefault();
		
		System.out.println(locale); 
		
//		ResourceBundle rb = ResourceBundle.getBundle("day17/dictionary", locale);
		ResourceBundle rb = ResourceBundle.getBundle("day17.Dictionary", locale);
		System.out.println(rb.getString("hello"));
		
	}
}
