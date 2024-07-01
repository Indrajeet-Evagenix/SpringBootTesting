package com.example.demo12.pdfCreater;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.*;

public class PdfCreaterExample {

    public void pdfWork() {
        List<Map<String,Object>> queryResult = null;
        Document document = new Document();

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document,byteArrayOutputStream);
            document.open();
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

    }
}
