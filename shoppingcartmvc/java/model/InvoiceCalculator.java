package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class InvoiceCalculator extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	@Override
	public int doEndTag() throws JspException {
		HttpSession session = pageContext.getSession();
		
		Map<String, List<String>> shoppingCart = (HashMap<String, List<String>>)session.getAttribute("shoppingCart");
		String qty="";
		String price = "";
		List<String> list = new ArrayList<String>();
		JspWriter out = pageContext.getOut();
	
		float total=0;
		int i=0;
		String item_code="";
		
		ItemMasterDTO itemDTO;
		List<ItemMasterDTO> itemList = new LinkedList<ItemMasterDTO>();
		
		for(Map.Entry<String, List<String>> m : shoppingCart.entrySet()){
			
			item_code = m.getKey();
			list = m.getValue();
			qty = list.get(1);
			price = list.get(2);
			
			itemDTO = ItemMasterDTO.getItemDTO();
			itemDTO.setItemCode(item_code);
			itemDTO.setItemName(list.get(0));
			itemDTO.setQty(Integer.parseInt(qty));
			itemDTO.setPrice(Float.parseFloat(price));
			itemList.add(itemDTO);
			
			total += Float.parseFloat(price)*Integer.parseInt(qty);
			i++;
		}
		
		InvoiceMasterDTO invoiceDTO = InvoiceMasterDTO.getinvoiceDTO();
		String name = (String)session.getAttribute("uname");
		LocalDate date = LocalDate.now();
		
		invoiceDTO.setCustName(name);
		invoiceDTO.setInvDate(date);
		invoiceDTO.setInvNo(3);
		invoiceDTO.setItemList(itemList);
		
		session.setAttribute("invoiceDTO", invoiceDTO);
		
		try {
			out.print(total);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return super.doEndTag();
	}
}
