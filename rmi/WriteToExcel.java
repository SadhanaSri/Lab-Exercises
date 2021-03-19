package day19;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

interface XMLToExcel {
	void initXls() throws Exception;
	void convertToExcel(InvoiceConverter invoice) throws Exception;
}

public class WriteToExcel implements XMLToExcel {
	private static int rowNum;
	private static XSSFWorkbook workbook;
	InvoiceConverter invoice;
	
	@Override
	public void convertToExcel(InvoiceConverter invoice) throws Exception {
		initXls();
		XSSFSheet sheet = workbook.getSheetAt(0);		
		Map<Integer, Object[]> map = new HashMap<>();
		
		
		int sno = invoice.getItemNo();
		String name = invoice.getItemName();
		float price = invoice.getPrice();
		float quantity = invoice.getQty();
		int unit = invoice.getUnit();
		float amount = invoice.getPrice();
		map.put(1, new Object[] {sno, name, unit, price, quantity, amount});

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
		
		FileOutputStream out = new FileOutputStream(new File("bill.xlsx"));
        workbook.write(out);
        workbook.close();
        out.close();
        System.out.println("bill.xlsx written successfully.");	
	}
						
	@Override
	public void initXls() throws Exception {
		workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Bill");
		CellStyle style = workbook.createCellStyle();
		Font boldFont = workbook.createFont();
		boldFont.setBold(true);
		style.setFont(boldFont);

		rowNum = 0;
		Row header = sheet.createRow(rowNum++);
		header.createCell(0).setCellValue("ITEMNO");
		header.createCell(1).setCellValue("NAME");
		header.createCell(2).setCellValue("UNIT");
		header.createCell(3).setCellValue("PRICE");
		header.createCell(4).setCellValue("QTY");
		header.createCell(5).setCellValue("AMOUNT");
	}		
}





