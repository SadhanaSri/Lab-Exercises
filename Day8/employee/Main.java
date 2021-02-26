package employee;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String department = sc.next();
		String role = sc.next();
		
		Employee employee = new Employee(name, department, role);
		Container.getDepartment(department, employee);
		System.out.println(employee);

		sc.close();
	}

}
