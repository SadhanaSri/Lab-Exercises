package day15;

import java.io.File;
import java.io.FilenameFilter;

public class IODemo2 {
	public static void main(String[] args) {
		File file = new File("abc.properties");
		System.out.println("Path.."+file.getAbsolutePath());
		System.out.println("Name.."+file.getName());
		System.out.println(file.exists()?"File Exists":"File does not exists");
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		System.out.println(file.isDirectory());
		
		File newFile = new File("c:/temp");
		file.renameTo(newFile);
		String s[] = newFile.list();
		
		for(String ss: s) {
			System.out.println(ss);
		}
//		FilenameFilter ff;
	
//		ff.accept( (File dir, String name) -> {
//			return name.endsWith("."+extension);
//		});
	}
}
//class MyFilter implements FilenameFilter {
//	String extension;
//	
//	public MyFilter(String extension) {
//		this.extension = extension;
//	}
//	
//	@Override
//	public boolean accept(File dir, String name) {
//		System.out.println(dir);
//		return name.endsWith("."+extension);
//	}
//}