package day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IODemo1 {
	public static void main(String[] args) {
		new CopyCommand().copy("abc.properties");
	}
}

class CopyCommand {
	public void copy(String filename) {
		FileInputStream fis = null;
//		resource block...executed automatically at the end
		try(FileOutputStream fos = new FileOutputStream("copyabc.properties")) {
			fis = new FileInputStream(filename);
			
			
			System.out.println("Total no of bytes: "+fis.available());
			int noOfBytesRead;
			byte b[] = new byte[8];
			
			while((noOfBytesRead = fis.read(b)) != -1) {
				String s = new String(b, 0 , noOfBytesRead);
				System.out.print(s);
				fos.write(b, 0, noOfBytesRead);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
