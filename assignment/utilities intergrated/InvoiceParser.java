package day15.component;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

interface Parser {
	public InvoiceParser parseData(String filename) throws Exception;
}

class InvoiceParser extends DefaultHandler implements Parser {
	private String custName;
	private int invNo;
	private String date;
	private float gst;
	private float amount;
	private float net;
	List<Items> itemList;
	
	private String elementValue;
	InvoiceParser inv;
	
	@Override
	public InvoiceParser parseData(String filename) throws Exception {
		InvoiceParser invoice;
		SAXParserFactory spf=SAXParserFactory.newInstance(); 
		SAXParser sp=spf.newSAXParser(); 
		sp.parse(filename, invoice = new InvoiceParser());
		return invoice;
	}
	
	public List<Items> getItemList() {
		return itemList;
	}
	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
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
	public void setInvNo(int qName) {
		this.invNo = qName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getGst() {
		return gst;
	}
	public void setGst(float gst) {
		this.gst = gst;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getNet() {
		return net;
	}
	public void setNet(float net) {
		this.net = net;
	}
			 
	 @Override 
	 public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException { 
		 switch(qName) {
		 case "items":
			 this.itemList = new ArrayList<>();
			 break;
		 case "item":
			 this.itemList.add(new Items());
			 break;
		 }
	 }
		
	 @Override 
	 public void endElement(String uri, String localName, String qName) throws SAXException { 
		 switch(qName) {
		 case "custName":
			 this.setCustName(elementValue);
			 break;
		 case "invNo":
			 this.setInvNo(Integer.parseInt(elementValue));
			 break;
		 case "date":
			 this.setDate(elementValue);
			 break;
		 case "itemNo":
			 getLatestItem().setItemNo(Integer.parseInt(elementValue));
			 break;
		 case "itemName":
			 getLatestItem().setItemName(elementValue);
			 break;
		 case "price":
			 getLatestItem().setPrice(Float.parseFloat(elementValue));
			 break;
		 case "qty":
			 getLatestItem().setQty(Float.parseFloat(elementValue));
			 break;
		 case "amount":
			 getLatestItem().setAmount(Float.parseFloat(elementValue));
			 break;
		 case "gst":
			 this.setGst(Float.parseFloat(elementValue));
			 break;
		 case "net":
			 this.setNet(Float.parseFloat(elementValue));
			 break;
		 }
	 } 
	 
	 private Items getLatestItem() {
		 List<Items> list = this.itemList;
		 int latest = list.size()-1;
		 return list.get(latest);
	 }
	 
	 public InvoiceParser getInvoice() {
		 return this;
	 }
	 
	 @Override 
	 public void characters(char[] ch, int start, int length) throws SAXException { 
		 elementValue = new String(ch, start, length);	 
	 }
}

class Items {
	private int itemNo;
	private String itemName;
	private float price;
	private float qty;
	private float amount;
	
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
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Items [itemNo=" + itemNo + ", itemName=" + itemName + ", price=" + price + ", qty=" + qty + ", amount="
				+ amount + "]";
	}
}
