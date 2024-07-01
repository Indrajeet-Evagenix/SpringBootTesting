package com.pdfExample.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CreateNewPdf {

    public void latestPdf() {

        String path = "/home/indrajeetgupta/Desktop/";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path + "FIrst.pdf"));
            document.open();
            document.add(new Paragraph("Hello Pdf"));
            document.close();

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
