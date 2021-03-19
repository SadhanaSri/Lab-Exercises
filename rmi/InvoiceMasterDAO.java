package day19;

import java.util.Set;

public interface InvoiceMasterDAO {
	public int insertInvoice(InvoiceMasterDTO invMasterDTO);
	public int deleteInvoice(int invNo) throws Exception;
	public int updateInvoice(InvoiceMasterDTO invMasterDTO);
	public InvoiceMasterDTO getInvoiceMaster(int invNo);
	public Set<InvoiceMasterDTO> getInvoiceMasterAll();
}
