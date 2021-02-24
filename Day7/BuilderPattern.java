package day7;

public class BuilderPattern {
	public static void main(String[] args) {
		Computer myComputer = new Computer.ComputerBuilder("HDD Enabled", "16GB RAM").build();
		Computer myComputer2=new Computer.ComputerBuilder("HDD Enabled","32GB RAM").
				setBluetooth("Bluetooth enabled").setGraphicsCard("Graphics card enabled").build();
		
		System.out.println(myComputer);
		System.out.println(myComputer2);
	}
}

class Computer {
	//fixed properties
	private String hdd="hu";
	private String ram;
	
	//optional properties
	private String graphicsCard;
	private String bluetooth;
	
	
	@Override
	public String toString() {
		return "Computer [hdd=" + hdd + ", ram=" + ram + ", graphicsCard=" + graphicsCard + ", bluetooth=" + bluetooth
				+ "]";
	}

	public Computer(ComputerBuilder builder) {
		this.hdd = builder.getHdd();
		this.ram = builder.getRam();
		this.graphicsCard = builder.getGraphicsCard();
		this.bluetooth = builder.getBluetooth();
	}
	
	public static class ComputerBuilder {
		private String hdd="hu";
		private String ram;
		private String graphicsCard;
		private String bluetooth;
		
		public ComputerBuilder(String hdd, String ram) {
			this.hdd = hdd;
			this.ram = ram;
		}
		
		public String getHdd() {
			return hdd;
		}
		public void setHdd(String hdd) {
			this.hdd = hdd;
		}
		public String getRam() {
			return ram;
		}
		public void setRam(String ram) {
			this.ram = ram;
		}
		public String getGraphicsCard() {
			return graphicsCard;
		}
		public ComputerBuilder setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}
		public String getBluetooth() {
			return bluetooth;
		}
		public ComputerBuilder setBluetooth(String bluetooth) {
			this.bluetooth = bluetooth;
			return this;
		}
		
		public Computer build() {
			return new Computer(this);
		}
	}
	
}
