package inheritance;

public class Program7 {
	public static void main(String[] args) {

	    final Demo2 obj = new Demo2();

	    Demo2 obj2 = new Demo2();
	    Demo2 obj3 = new Demo2();

	    obj2.setName("ram");
	    System.out.println(obj2.getName());

	    obj3 = obj2;  //allowed

	    System.out.println(obj3.getName());

	    //obj = obj2 //not allowed as obj is final and can not be modified

	    obj.setName("raj");
	    System.out.println(obj.getName());

	    //but the value of the instance variables, the obj is referring to
	    //can change

	    obj.setName("ravi");
	    System.out.println(obj.getName());

	}
}

class Demo2 {

	private String name;
	private String age;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

}
