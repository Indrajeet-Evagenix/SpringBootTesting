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
import java.util.ArrayList;
import java.util.List;

@Service
public class CreatePdfWithAllEmployees {

    @Autowired
    private PdfService pdfService;

    public void generatePdfAllEmployee(List<Employee> employee) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("/home/indrajeetgupta/Desktop/Employee.pdf"));
            document.open();
            createTitle(document);
            document.add(new Paragraph(" "));
            createTable(document, employee);
            System.out.println("---------Your PDF is Created----------");
            System.out.println("---------Your PDF is Created----------");
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTable(Document document, List<Employee> employee) {

        Paragraph paragraph = new Paragraph();
        paragraph.add(new Paragraph(" "));
        List<String> columnNameTables = new ArrayList<>();
        columnNameTables.add("Employee Id");
        columnNameTables.add("First Name");
        columnNameTables.add("Last Name");
        columnNameTables.add("Department");
        PdfPTable pdfPTable = new PdfPTable(columnNameTables.size());
        try {
            for (int i = 0; i < columnNameTables.size(); i++) {
                PdfPCell pdfPCell = new PdfPCell(new Phrase(columnNameTables.get(i)));
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

    private void getDbDataTable(PdfPTable pdfPTable, List<Employee> employee) {
        if (!employee.isEmpty()) {
            {
                for (Employee emp : employee) {
                    pdfPTable.setWidthPercentage(100);
                    pdfPTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfPTable.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

                    pdfPTable.addCell(String.valueOf(emp.getId()));
                    pdfPTable.addCell(emp.getFirstName());
                    pdfPTable.addCell(emp.getLastName());
                    pdfPTable.addCell(emp.getDepartment_name());

                }
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
