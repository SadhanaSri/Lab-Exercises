package day23;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Graphics;

public class ControlJava extends Applet {
	Font f = new Font("TimesRoman", Font.BOLD, 60);
	String Message;
	
	public void init() {
		Message = new String("Java Test");
	}
	
	public void SetMessage(String msg) {
		Message = msg;
		repaint();
	}
	
	public void paint(Graphics g) {
		g.setFont(f);
		g.drawString(Message, 15, 50);
	}
}
