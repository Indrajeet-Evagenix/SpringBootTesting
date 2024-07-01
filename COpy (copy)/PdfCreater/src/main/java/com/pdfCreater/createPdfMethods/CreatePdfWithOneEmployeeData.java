package com.pdfCreater.createPdfMethods;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pdfCreater.model.Employee;
import com.pdfCreater.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CreatePdfWithOneEmployeeData {

    @Autowired
    private PdfService pdfService;

    public void generatePdf(Employee employee) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("/home/indrajeetgupta/Desktop/Employee.pdf"));
            document.open();
            createTitle(document);
            document.add(new Paragraph(" "));
            createTable(document, employee);
            System.out.println("---------Your PDF is Created----------");
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTable(Document document, Employee employee) {

        Paragraph paragraph = new Paragraph();
        paragraph.add(new Paragraph(" "));
        PdfPTable pdfPTable = new PdfPTable(2);
        try {
            if (employee.getId() > 0) {
                PdfPCell pdfPCell = new PdfPCell(new Phrase("Emp ID"));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfPCell.setBackgroundColor(BaseColor.CYAN);
                pdfPTable.addCell(pdfPCell);
            }
            if (employee.getFirstName() != null) {
                PdfPCell pdfPCell = new PdfPCell(new Phrase("First Name"));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfPCell.setBackgroundColor(BaseColor.CYAN);
                pdfPTable.addCell(pdfPCell);
            }
            if (employee.getLastName() != null) {
                PdfPCell pdfPCell = new PdfPCell(new Phrase("Last Name"));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfPCell.setBackgroundColor(BaseColor.CYAN);
                pdfPTable.addCell(pdfPCell);
            }
            if (employee.getDepartment_name() != null) {
                PdfPCell pdfPCell = new PdfPCell(new Phrase("Department Name"));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfPCell.setBackgroundColor(BaseColor.CYAN);
                pdfPTable.addCell(pdfPCell);
            }
            getDbDataTable(pdfPTable, employee);
            document.add(pdfPTable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getDbDataTable(PdfPTable pdfPTable, Employee employee) {
        if (employee != null) {
            pdfPTable.setWidthPercentage(100);
            pdfPTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfPTable.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

            if (employee.getId() > 0) {
                pdfPTable.addCell(String.valueOf(employee.getId()));
            }
            if (employee.getFirstName() != null) {
                pdfPTable.addCell(employee.getFirstName());
            }
            if (employee.getLastName() != null) {
                pdfPTable.addCell(employee.getLastName());
            }
            if (employee.getDepartment_name() != null) {
                pdfPTable.addCell(employee.getDepartment_name());
            }
        }
    }

    private void createTitle(Document document) {
        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd"));
        Paragraph paragraph = new Paragraph();
        try {
            paragraph.add(new Paragraph("Employee_Report"));
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.add(new Paragraph(" "));
            paragraph.add(new Paragraph("Report Generated on " + localDateTime));

            document.add(paragraph);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
