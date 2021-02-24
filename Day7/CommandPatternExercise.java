package day7;

public class CommandPatternExercise {
	public static void main(String[] args) {
		Seva seva = new Seva();
		Police police = new Police();
		Hospital hosp = new Hospital();
		Corporation corporation = new Corporation();
		FoodSafety foodSafety=new FoodSafety();
		
		Command2 cmd1 = new HotelOpenCommand(hosp, police, foodSafety, corporation);
		Command2 cmd2 = new DeathCommand(hosp, police, foodSafety, corporation);

		seva.setCommand(cmd1, 0);
		seva.setCommand(cmd2, 1);
		
		seva.executeCommand(0);
	}
}

class Seva {
	Command2 command[] = new Command2[5];
	
	public Seva() {
		for(int i=0; i<5; i++) {
			command[i] = new DummyCommand();
		}
	}
	
	class DummyCommand extends Command2 {
		@Override
		public void execute() {
			System.out.println("Dummy command");
			
		}
	}
	
	public void setCommand(Command2 cmd, int no) {
		command[no] = cmd;
	}
	
	public void executeCommand(int no) {
		command[no].execute();
	}
}

abstract class Command2 {
	public abstract void execute();
	public Command2() {
		// TODO Auto-generated constructor stub
	}
	Hospital hosp;
	Police police;
	FoodSafety foodSafety;
	Corporation corporation;
	
	public Command2(Hospital hosp, Police police, FoodSafety foodSafety, Corporation corporation) {
		this.hosp = hosp;
		this.police = police;
		this.foodSafety = foodSafety;
		this.corporation = corporation;
	}
}

class HotelOpenCommand extends Command2 {
	public HotelOpenCommand(Hospital hosp, Police police, FoodSafety foodSafety, Corporation corporation) {
		this.hosp = hosp;
		this.police = police;
		this.foodSafety = foodSafety;
		this.corporation = corporation;
	}
	
	public void execute() {
		System.out.println("hotel opening process started");
		foodSafety.checkPremises();
		corporation.doInspection();
		police.doPoliceCertificate();
		foodSafety.giveFssCertificate();
		System.out.println("Hotel opening process over...now run the hotel............");
		
	}
}

class DeathCommand extends Command2 {
	public DeathCommand(Hospital hosp, Police police, FoodSafety foodSafety, Corporation corporation) {
		this.hosp = hosp;
		this.police = police;
		this.foodSafety = foodSafety;
		this.corporation = corporation;
	}
	
	@Override
	public void execute() {
		System.out.println("Foreign death Certificate process started........");
		police.doPoliceInvestigation();
		police.doPoliceCertificate();
		corporation.doInspection();
		hosp.doPostmortem();
		corporation.giveDeathCertificate();
		hosp.arrangeTransport();
		System.out.println("Foreign Death Certificate process over...now send the body............");
		
	}
}

class Police {
	public void doPoliceInvestigation() {
		System.out.println("Police doing investigation");
	}
	public void doPoliceCertificate() {
		System.out.println("Police certification given");
	}
}

class Hospital {
	public void doPostmortem() {
		System.out.println("postmortem done by hospital");
	}
	public void arrangeTransport() {
		System.out.println("body transport arranged");
	}
}

class Corporation {
	public void giveDeathCertificate() {
		System.out.println("death certificate given");
	}
	public void doInspection() {
		System.out.println("inspection done by corporation");
	}
}

class FoodSafety {
	public void checkPremises() {
		System.out.println("premises checked by FSS officials");
	}
	public void giveFssCertificate() {
		System.out.println("FSS certificate given");
	}
}
