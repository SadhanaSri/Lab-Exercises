package day15;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class IODemo3 {
	public static void main(String[] args) throws Exception {
		String str = "&copy Jack and Jill &copy;";
		ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());
		BufferedInputStream bfs = new BufferedInputStream(bis);
		
		System.out.println(bfs.markSupported());
		int c=0;
		boolean mark = false;
		
		while((c = bfs.read()) != -1) {
			switch((char)c) {
			case '&':
				if(!mark) {
					mark = true;
					bfs.mark(32);
				}
				break;
			case ';':
				if(mark) {
					System.out.print((char)169);
					mark = false;
				}
				break;
			case ' ':
				if(mark) {
					bfs.reset();
					mark = false;
					System.out.print("&");
				} else {
					System.out.print(" ");
				}
				break;
			default:
				if(!mark) {
					System.out.print((char)c);
				}
			}
		}
	}
}
