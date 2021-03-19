package day19;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

interface XMLToPDF {
	public void convertToPDF(InvoiceConverter invoice) throws Exception;
}

class XMLToPDFConverter implements XMLToPDF {
	InvoiceConverter invoice;
	
	@Override
	public void convertToPDF(InvoiceConverter invoice) throws Exception {
		Document doc = new Document();
		PdfWriter docWriter = null; 
		
		try {
			Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0)); 
			Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12); 
			
			docWriter = PdfWriter.getInstance(doc, new FileOutputStream("Invoice.pdf"));
			doc.addTitle("Invoice Details");
			doc.open();
			Paragraph paragraph = new Paragraph("INVOICE DETAILS");
			float[] columnWidths = {1.5f, 5f, 2f, 2f, 2f};
			PdfPTable table = new PdfPTable(columnWidths);
			table.setWidthPercentage(90f);
			
			
			insertCell(table, "Customer Name: "+invoice.getCustName(), Element.ALIGN_LEFT, 2, bfBold12);
			insertCell(table, "Invoice No: "+invoice.getInvNo(), Element.ALIGN_LEFT, 1, bfBold12);
			insertCell(table, "Date: "+invoice.getDate(), Element.ALIGN_LEFT, 2, bfBold12);
			
			insertCell(table, "Item No", Element.ALIGN_LEFT, 1, bfBold12);
			insertCell(table, "Item Name", Element.ALIGN_LEFT, 1, bfBold12);
			insertCell(table, "Price", Element.ALIGN_LEFT, 1, bfBold12);
			insertCell(table, "Qty", Element.ALIGN_LEFT, 1, bfBold12);
			insertCell(table, "Amount", Element.ALIGN_LEFT, 1, bfBold12);
			table.setHeaderRows(1);
			
			insertCell(table, String.valueOf(invoice.getItemNo()), Element.ALIGN_RIGHT, 1, bf12);
			insertCell(table, invoice.getItemName(), Element.ALIGN_LEFT, 1, bf12);
			insertCell(table, String.valueOf(invoice.getPrice()), Element.ALIGN_LEFT, 1, bf12);
			insertCell(table, String.valueOf(invoice.getQty()), Element.ALIGN_LEFT, 1, bf12);
			insertCell(table, "900" , Element.ALIGN_LEFT, 1, bf12);

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
