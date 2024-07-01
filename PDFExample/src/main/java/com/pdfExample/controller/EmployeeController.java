package com.pdfExample.controller;

import com.pdfExample.model.Employee;
import com.pdfExample.pdf.AllEmployeePDF;
import com.pdfExample.pdf.PdfGenerator;
import com.pdfExample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PdfGenerator pdfGenerator;

    @Autowired
    private AllEmployeePDF allEmployeePDF;

    @GetMapping("/getEmployee")
    public String getEmployeeDetails() {
        List<Employee> list = null;
        try {
            list = employeeRepository.getAllEmployee();
            if (list != null) {
                allEmployeePDF.generatePDF1(list);
                return "List of Employee Records";
            } else {
               return "Empty Employee Records";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @GetMapping("/getEmployee/{id}")
    public String getEmployeeById(@PathVariable("id") int id) {
        List<Employee> list = new ArrayList<>();
        Employee emp = null;
        try {
            emp = employeeRepository.getEmployeeById(id);
            list.add(emp);
            if (list != null) {
                pdfGenerator.generatePDF(list);
                return "List of Employee Records";
            } else {
                return "Empty Employee Records";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
