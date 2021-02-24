package day7;

public class CommandPattern {
	public static void main(String[] args) {
		Remote remote = new Remote();
		
		TV sony = new TV();
		XBox xbox = new XBox();
		SetTopBox tata = new SetTopBox();
		SoundSystem ss = new SoundSystem();
		
		Command cmd1 = new MusicChannelCommand(sony, tata, xbox, ss);
		Command cmd2 = new MovieChannelCommand(sony, tata, xbox, ss);
		Command cmd3 = new PlayGameCommand(sony, tata, xbox, ss);
		
		remote.assignCommand(cmd1, 1);
		remote.assignCommand(cmd2, 2);
		remote.assignCommand(cmd3, 3);
		
		remote.executeCommand(3);
	}
}

class Remote {
	Command command[] = new Command[5];
	
	public void setCommands() {
		for(int i=0; i<5; i++) {
			command[i] = new DummyCommand(); 
		}
	}
	
	public void assignCommand(Command cmd, int no) {
		command[no] = cmd; 
	}
	
	class DummyCommand extends Command{
		public void execute() {
			System.out.println("Dummy Command"); 
		}
	}
	
	public void executeCommand(int no) {
		command[no].execute();
	}
}

abstract class Command {
	TV sony;
	SetTopBox tata;
	XBox xbox;
	SoundSystem ss;
	
	public Command() {
		// TODO Auto-generated constructor stub
	}
	
	public Command(TV sony, SetTopBox tata, XBox xbox, SoundSystem ss) {
		this.sony = sony;
		this.tata = tata;
		this.xbox = xbox;
		this.ss = ss;
	}

	public abstract void execute();
}

class MusicChannelCommand extends Command {
	
	public MusicChannelCommand(TV sony, SetTopBox tata, XBox xbox, SoundSystem ss) {
		super(sony, tata, xbox, ss);
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		sony.switchOn();
		sony.setAVMode();
		tata.playMusicChannel();
		ss.tuneLowSound();
	}
}

class MovieChannelCommand extends Command {
	
	public MovieChannelCommand(TV sony, SetTopBox tata, XBox xbox, SoundSystem ss) {
		super(sony, tata, xbox, ss);
	}

	public void execute() {
		sony.switchOn();
		sony.setAVMode();
		tata.playMusicChannel();
		ss.tuneLowSound();
	}
}

class PlayGameCommand extends Command {
	public PlayGameCommand(TV sony, SetTopBox tata, XBox xbox, SoundSystem ss) {
		super(sony, tata, xbox, ss);
	}
	
	@Override
	public void execute() {
		sony.switchOn();
		tata.playGames();
		ss.tuneHighSound();
	}
}

class TV {
	public void switchOn() {
		System.out.println("TV Switched ON");
	}
	public void setAVMode() {
		System.out.println("AV Mode ON");
	}
}

class XBox {
	public void playGames() {
		System.out.println("Playing games....");
	}
}

class SetTopBox {
	public void playMusicChannel() {
		System.out.println("Music Channel ON");
	}
	
	public void playMovieChannel() {
		System.out.println("Movie Channel ON");
	}
	public void playGames() {
		System.out.println("Play games");
	}
}

class SoundSystem {
	public void tuneHighSound() {
		System.out.println("High sound");
	}
	
	public void tuneLowSound() {
		System.out.println("Low sound");
	}
}

