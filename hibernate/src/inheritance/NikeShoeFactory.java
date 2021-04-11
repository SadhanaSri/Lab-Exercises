package inheritance;

public class NikeShoeFactory extends ShoeFactory {
	private int sid;
	private String NSFShoeName;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getNSFShoeName() {
		return NSFShoeName;
	}
	public void setNSFShoeName(String shoeName) {
		NSFShoeName = shoeName;
	}
	@Override
	public String toString() {
		return "NikeShoeFactory [sid=" + sid + ", ShoeName=" + NSFShoeName + "]";
	}
	
	public void visit() {
		new Handler().handle(this);
	}
}
