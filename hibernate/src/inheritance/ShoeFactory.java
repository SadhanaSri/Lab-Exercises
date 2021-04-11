package inheritance;

public class ShoeFactory {
	private int sid;
	private String factoryName;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	@Override
	public String toString() {
		return "ShoeFactory [sid=" + sid + ", factoryName=" + factoryName + "]";
	}
	
	public void visit() {
		new Handler().handle(this);
	}
}
