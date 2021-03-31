package model;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerationAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		InvoiceMasterDTO invoiceDTO = (InvoiceMasterDTO)session.getAttribute("invoiceDTO");
		
		Document doc = new Document();
		PdfWriter docWriter = null; 
		
		try {
			Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0)); 
			Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12); 
			

			File file = new File("Invoice.pdf");
			if(!file.canRead())
		        file.setReadable(true);
			
			docWriter = PdfWriter.getInstance(doc, new FileOutputStream(file));
			doc.addTitle("Invoice Details");
			doc.open();
			Paragraph paragraph = new Paragraph("INVOICE DETAILS");
			float[] columnWidths = {1.5f, 5f, 2f, 2f, 2f};
			PdfPTable table = new PdfPTable(columnWidths);
			table.setWidthPercentage(90f);
			
			
			insertCell(table, "Customer Name: "+invoiceDTO.getCustName(), Element.ALIGN_LEFT, 2, bfBold12);
			insertCell(table, "Invoice No: "+invoiceDTO.getInvNo(), Element.ALIGN_LEFT, 1, bfBold12);
			insertCell(table, "Date: "+invoiceDTO.getInvDate(), Element.ALIGN_LEFT, 2, bfBold12);
			
			insertCell(table, "Item Code", Element.ALIGN_LEFT, 1, bfBold12);
			insertCell(table, "Item Name", Element.ALIGN_LEFT, 1, bfBold12);
			insertCell(table, "Price", Element.ALIGN_LEFT, 1, bfBold12);
			insertCell(table, "Qty", Element.ALIGN_LEFT, 1, bfBold12);
			insertCell(table, "Amount", Element.ALIGN_LEFT, 1, bfBold12);
			table.setHeaderRows(1);
			
			List<ItemMasterDTO> list= invoiceDTO.getItemList();
			float total=0;
			
			for(int i=0; i<list.size(); i++) {
				insertCell(table, String.valueOf(list.get(i).getItemCode()), Element.ALIGN_RIGHT, 1, bf12);
			    insertCell(table, list.get(i).getItemName(), Element.ALIGN_LEFT, 1, bf12);
			    insertCell(table, String.valueOf(list.get(i).getPrice()), Element.ALIGN_LEFT, 1, bf12);
			    insertCell(table, String.valueOf(list.get(i).getQty()), Element.ALIGN_LEFT, 1, bf12);
			    total += list.get(i).getPrice()*list.get(i).getQty();
			    insertCell(table, String.valueOf(list.get(i).getPrice()*list.get(i).getQty()), Element.ALIGN_LEFT, 1, bf12);
			}
			insertCell(table, "Total", Element.ALIGN_LEFT, 4, bfBold12);
			insertCell(table, String.valueOf(total), Element.ALIGN_LEFT, 2, bf12);
			
			paragraph.add(table);
			doc.add(paragraph);
			System.out.println("Invoice.pdf generated successfully....");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (doc != null){
			    doc.close();
			}
			if (docWriter != null){
			    docWriter.close();
			}
		}
		
		return "pdf.success";
	}
	
	private void insertCell(PdfPTable table, String text, int align, int colspan, Font font){
		  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
		  cell.setHorizontalAlignment(align);
		  cell.setColspan(colspan);
		  if(text.trim().equalsIgnoreCase("")){
			  cell.setMinimumHeight(10f);
		  }
		  table.addCell(cell);		   
	}
}
