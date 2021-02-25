package inheritance;

import java.util.Scanner;

public class Program14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String name = sc.next();
		System.out.println("Enter Roll No: ");
		int roll = sc.nextInt();
		System.out.println("Enter Maths marks: ");
		int math_mark = sc.nextInt();
		System.out.println("Enter Science marks: ");
		int science_mark = sc.nextInt();
		System.out.println("Enter English marks: ");
		int english_mark = sc.nextInt();
		
		Student student = new Student(name, roll);
		Result result = new Result();
		Exam exam = new Exam(math_mark, science_mark, english_mark);
		int total = result.calculateTotal(exam);
		
		System.out.println("===============RESULT==================");
		System.out.println(student);
		System.out.println("Total Marks: "+total);
		System.out.println("=======================================");
	}
}

class Student {
	String name;
	int roll;
	int math_mark;
	int science_mark;
	int english_mark;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int roll) {
		this.name = name;
		this.roll = roll;
	}
	
	public Student(int math_mark, int science_mark, int english_mark) {
		this.math_mark = math_mark;
		this.science_mark = science_mark;
		this.english_mark = english_mark;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + ", math_mark=" + math_mark + ", science_mark="
				+ science_mark + ", english_mark=" + english_mark + "]";
	}
	
	
}

class Exam extends Student {
	int math_mark;
	int science_mark;
	int english_mark;
	
	public Exam() {
	}
	
	public Exam(int math_mark, int science_mark, int english_mark) {
		super(math_mark, science_mark, english_mark);
		this.math_mark = math_mark;
		this.science_mark = science_mark;
		this.english_mark = english_mark;
	}
}

class Result extends Exam {
	int total_marks;

	public int calculateTotal(Exam exam) {
		total_marks = exam.math_mark + exam.science_mark + exam.english_mark;
		return total_marks;
	}
}