package com.pdfExample.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

public class PdfEdit {

    public void pdfEdit1() {

        PdfReader reader;
        String path = "/home/indrajeetgupta/Desktop/";
        {
            try {
                reader = new PdfReader(path + "Employee_Report.pdf");
                PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(path + "Edited_Employee_Report.pdf"));
                PdfContentByte contentByte = stamper.getOverContent(1);
                Document doc = new Document();
                Paragraph paragraph = new Paragraph("Newly Added in PDF First Page");

                BaseFont baseFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
                contentByte.setFontAndSize(baseFont, 12);

                contentByte.beginText();
                contentByte.showTextAligned(PdfContentByte.ALIGN_CENTER, "This is the edited content on the first page.", 297.5f, 800, 0);
                contentByte.endText();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
