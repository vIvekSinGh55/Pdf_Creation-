package com.file.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService 
{

	private Logger logger = LoggerFactory.getLogger(PdfService.class);
	
	public ByteArrayInputStream createPdf()
	{
		logger.info("Create PDF Started");
		
		String title = "Welcome Industries";
		String content = "We are learning how to generate the pdf.";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		Document document = new Document();
		
		PdfWriter.getInstance(document, out);
		
		 HeaderFooter footer = new HeaderFooter(true, new Phrase(" Learn "));
         footer.setAlignment(Element.ALIGN_CENTER);
         footer.setBorderWidthBottom(0);
         document.setFooter(footer);
		
		
		document.open();
		
		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
		Paragraph titleParagraph = new Paragraph(title,titleFont);
		titleParagraph.setAlignment(Element.ALIGN_RIGHT);
		document.add(titleParagraph);
		
		Font paraFont = FontFactory.getFont(FontFactory.HELVETICA, 16);
		Paragraph paragraph = new Paragraph(content,paraFont);
//		paragraph.setAlignment(Element.ALIGN_CENTER);
		paragraph.add(new Chunk("wow this line add after creating paragraph"));
		document.add(paragraph);
		
		document.close();
		
		return new ByteArrayInputStream(out.toByteArray());
		
	}
}
