package compkey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "INVOICE_DETAILS")
public class Invoice {
	@EmbeddedId
	@Column(name="COMPKEY", nullable = false)
	private CompKey compkey;
	
	@Column(name="DETAILS", nullable = false)
	private String details;
	
	public CompKey getCompkey() {
		return compkey;
	}
	public void setCompkey(CompKey compkey) {
		this.compkey = compkey;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}
