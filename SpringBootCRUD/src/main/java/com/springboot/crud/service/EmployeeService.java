package com.springboot.crud.service;

import com.springboot.crud.entity.Employee;

import java.util.*;

public interface EmployeeService {

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

    String updateEmployee(Employee employee, int id);

    String deleteEmployeeById(int id);

    String addEmployee(Employee employee);
}
