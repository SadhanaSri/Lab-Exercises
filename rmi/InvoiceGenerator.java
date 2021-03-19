package day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface ReportGenerator {
	public void generateInvoice() throws Exception;
}

public class InvoiceGenerator implements ReportGenerator {
	@Override
	public void generateInvoice() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter invoice no: ");
		int invNo = Integer.parseInt(br.readLine());
		System.out.println("Enter invoice date: ");
		String invDate = br.readLine();
		System.out.println("Enter customer no: ");
		int custNo = Integer.parseInt(br.readLine());
		System.out.println("Enter customer name: ");
		String custName = br.readLine();
		System.out.println("Enter customer address: ");
		String custAddress = br.readLine();
		System.out.println("Enter customer email: ");
		String custEmail = br.readLine();
		System.out.println("Enter customer phone: ");
		String custPhone = br.readLine();
		System.out.println("Enter item no: ");
		int itemNo = Integer.parseInt(br.readLine());
		System.out.println("Enter item name: ");
		String itemName = br.readLine();
		System.out.println("Enter item unit: ");
		int itemUnit = Integer.parseInt(br.readLine());
		System.out.println("Enter item price: ");
		float price = Float.parseFloat(br.readLine());
		System.out.println("Enter item qty: ");
		int qty = Integer.parseInt(br.readLine());
		
		InvoiceManager storeInvoice = new InvoiceManager();
		
		InvoiceMasterDTO invMasterDTO = new InvoiceMasterDTO();
		invMasterDTO.setInvno(invNo);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		invMasterDTO.setInvDate(LocalDate.parse(invDate, formatter));
		invMasterDTO.setCustomerno(custNo);
		
		storeInvoice.setInvoiceDTO(invMasterDTO);
		InvoiceMasterDAO inv = new InvoiceMasterDAOImpl();
		System.out.println(inv.insertInvoice(invMasterDTO));
		
		CustomerMasterDTO custMasterDTO = new CustomerMasterDTO();
		custMasterDTO.setCustNo(custNo);
		custMasterDTO.setCustName(custName);
		custMasterDTO.setCustAddress(custAddress);
		custMasterDTO.setCustEmail(custEmail);
		custMasterDTO.setCustPhone(custPhone);
		
		storeInvoice.setCustomerDTO(custMasterDTO);
		CustomerMasterDAOImpl cust = new CustomerMasterDAOImpl();
		System.out.println(cust.insertCustomer(custMasterDTO));
		
		ItemMasterDTO itemMasterDTO = new ItemMasterDTO();
		itemMasterDTO.setItemNo(itemNo);
		itemMasterDTO.setItemName(itemName);
		itemMasterDTO.setItemPrice(price);
		itemMasterDTO.setItemUnit(itemUnit);
		
		storeInvoice.setItemDTO(itemMasterDTO);
		ItemMasterDAOImpl item = new ItemMasterDAOImpl();
		System.out.println(item.insertItem(itemMasterDTO));
		
		TransactionMasterDTO transMasterDTO = new TransactionMasterDTO();
		transMasterDTO.setInvno(invNo);
		transMasterDTO.setItemNo(itemNo);
		transMasterDTO.setQty(qty);
		
		storeInvoice.setTransDTO(transMasterDTO);
		TransactionMasterDAOImpl trans = new TransactionMasterDAOImpl();
		System.out.println(trans.insertTransaction(transMasterDTO));
		
		storeInvoice.serializeInvoice();

	}
}
