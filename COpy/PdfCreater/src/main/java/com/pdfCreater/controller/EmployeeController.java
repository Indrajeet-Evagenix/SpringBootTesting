package com.pdfCreater.controller;

import com.pdfCreater.createPdfMethods.CreatePdfWithAllEmployees;
import com.pdfCreater.createPdfMethods.CreatePdfWithOneEmployeeData;
import com.pdfCreater.model.Employee;
import com.pdfCreater.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private PdfService pdfService;

    @Autowired
    private CreatePdfWithOneEmployeeData createPdf;

    @Autowired
    private CreatePdfWithAllEmployees createPdfAll;

    @GetMapping("/create/{id}")
    public String createPdfByEmployeeId(@PathVariable("id") int id) {
        Employee employee = null;
        employee = pdfService.getEmployeeById(id);
        if (employee != null) {
            createPdf.generatePdf(employee);
            return "Pdf is Created";
        } else {
            return "Employee with this id:"+id+" does not exist.";
        }
    }

    @GetMapping("/create")
    public String createPdfWithAllEmployee() {
        List<Employee> employee = null;
        employee = pdfService.getAllEmployee();
        if (employee != null) {
            createPdfAll.generatePdfAllEmployee(employee);
            //Added Comment
            return "Pdf is Created";
        } else {
            return "Employee does not exist.";
        }
    }
}
