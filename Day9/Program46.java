package day9;

public class Program46 {
		public static void main(String[] args) {
			CitiBank2 bank = new CitiBank2("Sadhana", "SK12345", "savings", 10000);
			bank.depositAmount(2000);
			bank.displayDetails();
		}

	}

class CitiBank2 {
	String name;
	String acc_no;
	String acc_type;
	float balance;
		
	
	public CitiBank2(String name, String acc_no, String acc_type, float balance) {
		super();
		this.name = name;
		this.acc_no = acc_no;
		this.acc_type = acc_type;
		this.balance = balance;
	}

	public void depositAmount(float amount) {
		checkBalance();
		balance=balance+amount;
		System.out.println("Successfully Deposited!!!");
		checkBalance();
	}
		
	public void checkBalance() {
		System.out.println("\nYour balance is: "+balance);
	}
		
		public void displayDetails() {
			System.out.println("\n\n====================WELCOME TO CITIBANK===================");
			System.out.println("======================ACCOUNT DETAILS=====================");
			System.out.println("Account Holder: "+name);
			System.out.println("Balance: "+balance);
			System.out.println("==================THANK YOU! VISIT AGAIN!==================");
		}

}
