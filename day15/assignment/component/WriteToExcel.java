package day15.component;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

interface XMLToExcel {
	void writeData() throws Exception;
	void initXls() throws Exception;
}

public class WriteToExcel implements XMLToExcel {
	private static int rowNum;
	private static XSSFWorkbook workbook;
	    
	@Override
	public void writeData() throws Exception {
		initXls();
		XSSFSheet sheet = workbook.getSheetAt(0);		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setValidating(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse("invoices.xml");
		Map<Integer, Object[]> map = new TreeMap<>();

		NodeList list = doc.getElementsByTagName("invoice");

		for(int i=0; i<list.getLength(); i++) {
			Node item = list.item(i);
			if(item.getNodeType() == Node.ELEMENT_NODE) {				
				NodeList nlist = item.getChildNodes();
				Element ele = (Element)nlist;
				int sno = Integer.parseInt(ele.getElementsByTagName("sno").item(0).getTextContent());
				String name = ele.getElementsByTagName("item").item(0).getTextContent();
				int unit = Integer.parseInt(ele.getElementsByTagName("unit").item(0).getTextContent());
				float price = Integer.parseInt(ele.getElementsByTagName("price").item(0).getTextContent());
				float quantity = Integer.parseInt(ele.getElementsByTagName("qty").item(0).getTextContent());
				float amount = Integer.parseInt(ele.getElementsByTagName("amount").item(0).getTextContent());
		
				map.put(i, new Object[] {sno, name, unit, price, quantity, amount});
			}
		}
		

		Set<Integer> keyset = map.keySet();
		
		for(Integer key : keyset) {
			Row row = sheet.createRow(rowNum++);
			Object[] arr = map.get(key);
			int cellnum = 0;
			
			for(Object obj : arr) {
				Cell cell = row.createCell(cellnum++);
				if(obj instanceof String) 
					cell.setCellValue((String)obj);
				else if(obj instanceof Integer)
					cell.setCellValue((Integer)obj);
				else
					cell.setCellValue((Float)obj);
			}
		}
		
		FileOutputStream out = new FileOutputStream(new File("c:\\temp\\bill.xlsx"));
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
//		        style.setAlignment(CellStyle.ALIGN_CENTER);
	      
		        rowNum = 0;
		        Row header = sheet.createRow(rowNum++);
		        header.createCell(0).setCellValue("SNO");
		        header.createCell(1).setCellValue("NAME");
		        header.createCell(2).setCellValue("UNIT");
		        header.createCell(3).setCellValue("PRICE");
		        header.createCell(4).setCellValue("QTY");
		        header.createCell(5).setCellValue("AMOUNT");
	}
}





