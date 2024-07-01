package com.springboot.crud.controller;

import com.springboot.crud.entity.Employee;
import com.springboot.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
            String result = employeeService.addEmployee(employee);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        List<Employee> list = null;
        list = employeeService.getAllEmployee();
        return list;
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) {
        String str = employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(str, HttpStatus.ACCEPTED);

    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<String> updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {
        String str = employeeService.updateEmployee(employee, id);
        return new ResponseEntity<>(str, HttpStatus.OK);

    }
}
