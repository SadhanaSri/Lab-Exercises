package model;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelGenerationAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Bill");
		
		CellStyle style = workbook.createCellStyle();
		Font boldFont = workbook.createFont();
		boldFont.setBold(true);
		style.setFont(boldFont);

		int rowNum = 0;
		Row header = sheet.createRow(rowNum++);
		header.createCell(0).setCellValue("ITEM CODE");
		header.createCell(1).setCellValue("NAME");
		header.createCell(2).setCellValue("QTY");
		header.createCell(3).setCellValue("PRICE");
		header.createCell(4).setCellValue("AMOUNT");
		
				
		Map<Integer, Object[]> map = new HashMap<>();
		
		HttpSession session = request.getSession();
		InvoiceMasterDTO invoiceDTO = (InvoiceMasterDTO)session.getAttribute("invoiceDTO");
		
		List<ItemMasterDTO> itemList = invoiceDTO.getItemList();
		
		for(int i=0; i<itemList.size(); i++) {
			String item_code = itemList.get(i).getItemCode();
			String item_name = itemList.get(i).getItemName();
			int qty = (int) itemList.get(i).getQty();
			float price = itemList.get(i).getPrice();
			float amount = qty*price;
			map.put(i, new Object[] {item_code, item_name, qty, price, amount});
		}
		

		Set<Integer> keyset = map.keySet();
		
		for(Integer key : keyset) {
			Row row = sheet.createRow(rowNum++);
			Object[] arr = map.get(key);
			int cellnum = 0;
			
			for(Object obj : arr) {
				Cell cell = row.createCell(cellnum++);
				if(obj instanceof String) {
					cell.setCellValue((String)obj);
					System.out.println((String)obj);
				} 
					
				else if(obj instanceof Integer) {
					cell.setCellValue((Integer)obj);
					System.out.println((Integer)obj);
				}
					
				else {
					cell.setCellValue((Float)obj);
					System.out.println((Float)obj);
				}
			}
		}
		
		try {
			FileOutputStream out = new FileOutputStream(new File("invoice.xlsx"));
	        workbook.write(out);
	        workbook.close();
	        out.close();
	        System.out.println("invoice.xlsx written successfully.");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "excel.success";
	}
}
