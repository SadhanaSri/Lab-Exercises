package day19;

interface Converter {
	public void doExcelConversion(int invNo) throws Exception;
	public void doPDFConversion(int invNo) throws Exception;
	public void init(int invNo) throws Exception;
}

public class InvoiceConverter implements Converter {
	private String custName;
	private int invNo;
	private String date;
//	List<Items> itemList;
	private int itemNo;
	private String itemName;
	private float price;
	int unit;
	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	private float qty;
	
//	public InvoiceConverter() {
//		InvoiceConverter converter = new InvoiceConverter();
//	}
	
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getInvNo() {
		return invNo;
	}

	public void setInvNo(int invNo) {
		this.invNo = invNo;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}
	
	public InvoiceConverter getInvoiceConverter() {
		return this;
	}

	public void init(int invNo) throws Exception {
		InvoiceMasterDAOImpl invoiceDAO = new InvoiceMasterDAOImpl();
		InvoiceMasterDTO invoiceDTO = 	invoiceDAO.getInvoiceMaster(invNo);
		
		String invDate = String.valueOf(invoiceDTO.getInvDate());
		int custNo = invoiceDTO.getCustomerno();
				
		CustomerMasterDAOImpl custDAO = new CustomerMasterDAOImpl();
		CustomerMasterDTO custDTO = custDAO.getCustomerMaster(custNo);
		
		String custName = custDTO.getCustName();
		
		TransactionMasterDAOImpl trans = new TransactionMasterDAOImpl();
		TransactionMasterDTO transDTO = trans.getTransactionMaster(invNo);
		int itemNo = transDTO.getItemNo();
		int qty = transDTO.getQty();
		
		ItemMasterDAOImpl itemDAO = new ItemMasterDAOImpl();
		ItemMasterDTO itemMasterDTO = itemDAO.getItemMaster(itemNo);
	
		String itemName = itemMasterDTO.getItemName();
		Float itemPrice = itemMasterDTO.getItemPrice();
		int itemUnit = itemMasterDTO.getItemUnit();
		
		this.setInvNo(invNo);
		this.setDate(invDate);
		this.setCustName(custName);
		this.setItemNo(itemNo);
		this.setItemName(itemName);
		this.setPrice(itemPrice);
		this.setQty(qty);
		this.setUnit(itemUnit);
		
//		System.out.println(this.getDate());
//		System.out.println(this.getCustName());
//		System.out.println(this.getItemNo());
//		System.out.println(this.getItemName());
//		System.out.println(this.getPrice());
//		System.out.println(this.getQty());
//		
	}
	
	public void doExcelConversion(int invNo) throws Exception {
		this.init(invNo);
		WriteToExcel obj = new WriteToExcel();
		obj.convertToExcel(this);
			
	}
	
	public void doPDFConversion(int invNo) throws Exception {
		this.init(invNo);
		XMLToPDFConverter obj = new XMLToPDFConverter();
		obj.convertToPDF(this);
	}
}
