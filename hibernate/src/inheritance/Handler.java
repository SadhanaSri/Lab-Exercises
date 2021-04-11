package inheritance;

public class Handler {
	public void handle(ShoeFactory sf) {
		System.out.println(sf.getFactoryName());
	}
	
	public void handle(BataShoeFactory bsf) {
		System.out.println(bsf.getFactoryName()+":"+bsf.getBSFShoeName());
	}
	
	public void handle(NikeShoeFactory nsf) {
		System.out.println(nsf.getFactoryName()+":"+nsf.getNSFShoeName());
	}
}
