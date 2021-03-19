package day19;

import java.io.Serializable;

public class ItemMasterDTO implements Serializable {
	private int itemNo;
	private String itemName;
	private float itemPrice;
	private int itemUnit;
	
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
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemUnit() {
		return itemUnit;
	}
	public void setItemUnit(int itemUnit) {
		this.itemUnit = itemUnit;
	}
	@Override
	public String toString() {
		return "ItemMasterDTO [itemNo=" + itemNo + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", ItemUnit="
				+ itemUnit + "]";
	}
	
}
