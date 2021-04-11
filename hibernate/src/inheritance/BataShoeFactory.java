package inheritance;

public class BataShoeFactory extends ShoeFactory {
	private int sid;
	private String BSFShoeName;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getBSFShoeName() {
		return BSFShoeName;
	}
	public void setBSFShoeName(String shoeName) {
		BSFShoeName = shoeName;
	}
	@Override
	public String toString() {
		return "BataShoeFactory [sid=" + sid + ", ShoeName=" + BSFShoeName + "]";
	}
	
	public void visit() {
		new Handler().handle(this);
	}
}
