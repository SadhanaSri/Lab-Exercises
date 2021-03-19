package day19;

import java.io.Serializable;
import java.time.LocalDate;

public class InvoiceMasterDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int invno;
	private LocalDate invDate;
	private int custNo;
	
	public int getInvno() {
		return invno;
	}
	public void setInvno(int invno) {
		this.invno = invno;
	}
	public LocalDate getInvDate() {
		return invDate;
	}
	public void setInvDate(LocalDate invDate) {
		this.invDate = invDate;
	}
	public int getCustomerno() {
		return custNo;
	}
	public void setCustomerno(int customerno) {
		this.custNo = customerno;
	}
	@Override
	public String toString() {
		return "InvoiceMasterDTO [invno=" + invno + ", customerno=" + custNo + "]";
	}	
}
