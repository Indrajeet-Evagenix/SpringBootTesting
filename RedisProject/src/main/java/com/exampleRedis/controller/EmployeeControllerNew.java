package com.exampleRedis.controller;

import com.exampleRedis.dao.EmployeeDaoNew;
import com.exampleRedis.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/new")
public class EmployeeControllerNew {

    @Autowired
    private EmployeeDaoNew employeeDao;

    @PostMapping(value = "/create",consumes = "application/json")
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId("155");
        return employeeDao.saveEmployee(employee);
    }
/*
    @GetMapping("/getEmployee/{id}")
    public String getEmployeeById(@PathVariable("id") String id) {
        return employeeDao.getEmployee(id);
    }

    @GetMapping("/getAllEmployee")
    public Map<Object, Object> getAllEmployee() {

        employeeDao.findAll().forEach((k, v) -> System.out.println(k + "--->" + v));
        *//*Map<Object, Object> map = employeeDao.findAll();
        Collection<Object> list = map.values();
        List<Employee> empList = list.stream().map(val->(Employee) val).collect(Collectors.toList());
        System.out.println(empList);*//*
        return employeeDao.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") String id) {
        employeeDao.delete(id);
    }*/
}
