package day19;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InvoiceManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private Set<InvoiceManager> invoiceList; 
	private InvoiceMasterDTO invoiceDTO;
	private CustomerMasterDTO customerDTO;
	private TransactionMasterDTO transDTO;
	private ItemMasterDTO itemDTO;
	
	public InvoiceMasterDTO getInvoiceDTO() {
		return invoiceDTO;
	}

	public void setInvoiceDTO(InvoiceMasterDTO invoiceDTO) {
		this.invoiceDTO = invoiceDTO;
	}

	public CustomerMasterDTO getCustomerDTO() {
		return customerDTO;
	}

	public void setCustomerDTO(CustomerMasterDTO customerDTO) {
		this.customerDTO = customerDTO;
	}

	public TransactionMasterDTO getTransDTO() {
		return transDTO;
	}

	public void setTransDTO(TransactionMasterDTO transDTO) {
		this.transDTO = transDTO;
	}

	public ItemMasterDTO getItemDTO() {
		return itemDTO;
	}

	public void setItemDTO(ItemMasterDTO itemDTO) {
		this.itemDTO = itemDTO;
	}

	public Set<InvoiceManager> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(Set<InvoiceManager> invoiceList) {
		this.invoiceList = invoiceList;
	}

	
//	@Override
//	public String toString() {
//		return "InvoiceManager [invoiceList=" + invoiceList + ", invoiceDTO=" + invoiceDTO + ", customerDTO="
//				+ customerDTO + ", transDTO=" + transDTO + ", itemDTO=" + itemDTO + "]";
//	}

	public void serializeInvoice() {
		invoiceList = new HashSet<>();
		invoiceList.add(this);
		this.setInvoiceList(invoiceList);
		
		System.out.println("invoicelist......");
//		Iterator<InvoiceManager> iter = invoiceList.iterator();
		
//		while(iter.hasNext()) {
//			System.out.println((iter.next()).toString());
//		}
//		
		System.out.println("invoice......."+(this.invoiceDTO).getInvno());
		
	    FileOutputStream fop;
		try {
			String filename="invoice"+(this.invoiceDTO).getInvno()+".dat";
			System.out.println("filename..."+filename);
			fop = new FileOutputStream(new File(filename));
			ObjectOutputStream oos=new ObjectOutputStream(fop);
		    oos.writeObject(invoiceList);
		    oos.close();
		    fop.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
       
	}
}
