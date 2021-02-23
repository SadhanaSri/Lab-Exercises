package day6;

public class KaitanFan {
	FanState state = new OffState();
	public void pull() {
		state.changeState(this);
	}
}

abstract class FanState {
	FanState state;
	abstract void changeState(KaitanFan fan);
}

class OnState extends FanState{
	public void changeState(KaitanFan fan) {
		System.out.println("Medium state");
		fan.state = new MediumState();
	}
}

class MediumState extends FanState{
	public void changeState(KaitanFan fan) {
		System.out.println("HighSpeed state");
		fan.state = new HighSpeedState();
	}
}

class HighSpeedState extends FanState{
public void changeState(KaitanFan fan) {
	System.out.println("Off state");
	fan.state = new OffState();
	}
}

class OffState extends FanState{
	public void changeState(KaitanFan fan) {
		System.out.println("On state");
		fan.state = new OnState();
	}
}
