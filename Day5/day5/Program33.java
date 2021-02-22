package day5;

public class Program33 {

	public static void main(String[] args) {
		Background b = new Background();
		b.run();

	}

}

class Background implements Runnable{
	 int i=0;
//	 Return type is incompatible with Runnable.run();
//	 public int run(){
	 public void run(){
	 while(true){
	 i++;
	 System.out.println("i="+i);
	 } //End while
//	 return 1;
	 }//End run
	}//End class 
