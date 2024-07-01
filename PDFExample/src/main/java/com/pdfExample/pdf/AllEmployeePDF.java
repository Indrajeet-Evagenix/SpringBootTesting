package com.pdfExample.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pdfExample.model.Employee;
import com.pdfExample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AllEmployeePDF {

    private static Font COURIER = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);
    private static Font COURIER_SMALL = new Font(Font.FontFamily.COURIER, 16, Font.BOLD);
    private static Font COURIER_SMALL_FOOTER = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);


    public void generatePDF1(List<Employee> list) {

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(getPdfNameWithDate()));
            document.open();
            addDocTitle(document);
            createTable(document, 4, list);
            document.newPage();
            addFooter(document);
            document.close();
            System.out.println("----------Your PDF Report is Ready----------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addDocTitle(Document document) {
        String localStringDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd"));

        Paragraph p1 = new Paragraph();
        try {
            leaveEmptyLine(p1, 1);
            p1.add(new Paragraph("Employee_Report", COURIER));
            p1.setAlignment(Element.ALIGN_CENTER);
            leaveEmptyLine(p1, 1);
            p1.add(new Paragraph("Report Generated on " + localStringDate, COURIER_SMALL));

            document.add(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createTable(Document document, int numberOfColumns, List<Employee> list) {
        Paragraph paragraph = new Paragraph();
        try {

            leaveEmptyLine(paragraph, 3);
            document.add(paragraph);
            List<String> columnNameTable = new ArrayList<>();
            columnNameTable.add("Emp Id");
            columnNameTable.add("Emp Name");
            columnNameTable.add("Emp Department");
            columnNameTable.add("Emp Salary");
            PdfPTable table = new PdfPTable(columnNameTable.size());
            for (int i = 0; i < columnNameTable.size(); i++) {
                    PdfPCell cell = new PdfPCell(new Phrase(columnNameTable.get(i)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.CYAN);
                    table.addCell(cell);

            }
            getDbDataTable(table, list);
            document.add(table);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getDbDataTable(PdfPTable table, List<Employee> list) {

        if (list != null) {
            for (Employee emp : list) {
                table.setWidthPercentage(100);
                table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
                table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

                table.addCell(String.valueOf(emp.getEmpId()));
                table.addCell(emp.getEmpName());
                table.addCell(emp.getEmpDepartment());
                table.addCell("$" + emp.getEmpSalary());
            }
        }

    }

    private void leaveEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private String getPdfNameWithDate() {
        String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd"));
        return "/home/indrajeetgupta/Desktop/" + "Employee_Report" + ".pdf";
    }

    private void addFooter(Document document) {
        Paragraph paragraph = new Paragraph();
        try {
            leaveEmptyLine(paragraph, 2);
            paragraph.setAlignment(Element.ALIGN_MIDDLE);
            paragraph.add(new Paragraph("---------------End of " + "Employee_Report"
                    + "-----------------", COURIER_SMALL_FOOTER));
            document.add(paragraph);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

