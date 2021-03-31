package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class InvoiceMasterDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String custName;
	private int invNo;
	private LocalDate invDate;
	private List<ItemMasterDTO> itemList;
	
	public InvoiceMasterDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public InvoiceMasterDTO(String custName, int invNo, LocalDate invDate, List<ItemMasterDTO> itemList) {
		super();
		this.custName = custName;
		this.invNo = invNo;
		this.invDate = invDate;
		this.itemList = itemList;
	}

	public static InvoiceMasterDTO invoiceDTO;
	
	public static InvoiceMasterDTO getinvoiceDTO() {
		if(invoiceDTO == null) {
			return new InvoiceMasterDTO();
		} else {
			return invoiceDTO.createClone();
		}
	}
	
	public InvoiceMasterDTO createClone() {
		try {
			return (InvoiceMasterDTO)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
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
	
	public LocalDate getInvDate() {
		return invDate;
	}

	public void setInvDate(LocalDate invDate) {
		this.invDate = invDate;
	}

	public List<ItemMasterDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemMasterDTO> itemList) {
		this.itemList = itemList;
	}
}

class ItemMasterDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String itemCode;
	private String itemName;
	private float price;
	private float qty;
	
	
	public ItemMasterDTO(String itemCode, String itemName, float price, float qty) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.price = price;
		this.qty = qty;
	}

	public ItemMasterDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public static ItemMasterDTO itemDTO;
	
	public static ItemMasterDTO getItemDTO() {
		if(itemDTO == null) {
			return new ItemMasterDTO();
		} else {
			return itemDTO.createClone();
		}
	}
	
	public ItemMasterDTO createClone() {
		try {
			return (ItemMasterDTO)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
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
}

	