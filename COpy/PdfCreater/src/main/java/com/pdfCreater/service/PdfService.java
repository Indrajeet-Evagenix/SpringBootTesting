package com.pdfCreater.service;

import com.pdfCreater.model.Employee;

import java.util.List;
import java.util.Map;

public interface PdfService {

    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);
}
