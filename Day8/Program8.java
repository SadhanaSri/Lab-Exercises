package inheritance;

public class Program8 {

	public static void main(String[] args) {
		int var = 20;
		Singleton s = Singleton.getValue(20);
		System.out.println(s.var);
	}
}
class Singleton
{
	public static int var;
	private Singleton(int value)
	{
		var=value;
	}
	public static Singleton getValue(int value)
	{
		return new Singleton(value);
	}
}