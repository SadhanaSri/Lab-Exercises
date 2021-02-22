package day5;

public class ArrayDemo2 {

	public static void main(String[] args) {
		//reading/processing array
		String s[] = {"hello", "world"};
		
		for(String ss: s)
			System.out.println(ss);
		
		int size = s.length;
		
		//complex type object array
		Command cmd[][] = new Command[2][2];
		cmd[0][0] = new Command("row:1 col:1");
		cmd[0][1] = new Command("row:1 col:2");
		cmd[1][0] = new Command("row:2 col:1");
		cmd[1][1] = new Command("row:2 col:2");
		
		for(Command c[]: cmd) {
			for(Command com: c) {
				System.out.println(com+"\t");
			}
			System.out.println();
		}
	}
}

class Command {
	String msg;
	public Command(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return this.msg;
	}
}
