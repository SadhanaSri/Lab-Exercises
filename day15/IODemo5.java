package day15;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.io.StringBufferInputStream;

public class IODemo5 {
	public static void main(String[] args) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream("hello world".getBytes());
		StringBufferInputStream sbis = new StringBufferInputStream("hi world");
		
		SequenceInputStream sis = new SequenceInputStream(bis, sbis);
		
		int c=0;
		
		while((c = sis.read())!=-1) {
			System.out.print((char)c);
		}
		
	}
}
