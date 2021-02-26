package bank;

public class Main {
	public static void main(String[] args) {
		Bank bank[] = new Bank[3];
		bank[0].assignValues("Jane", "SK12305", "savings", 10000);
		bank[0].displayDetails();
		bank[1].assignValues("Steffy", "SK19345", "savings", 20000);
		bank[1].displayDetails();
		bank[2].assignValues("Lia", "SK12347", "savings", 19000);
		bank[2].displayDetails();
	}

}

class Bank {
	String name;
	String acc_no;
	String acc_type;
	float balance;
	
	public void assignValues(String name, String acc_no, String acc_type, float balance) {
		this.name = name;
		this.acc_no = acc_no;
		this.acc_type = acc_type;
		this.balance = balance;
	}
	
	public void displayDetails() {
		System.out.println("\n\n====================WELCOME TO CITIBANK===================");
		System.out.println("======================ACCOUNT DETAILS=====================");
		System.out.println("Account Holder: "+name);
		System.out.println("Balance: "+balance);
		System.out.println("==================THANK YOU! VISIT AGAIN!==================");
	}
}

