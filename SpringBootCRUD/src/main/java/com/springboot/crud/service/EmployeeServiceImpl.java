package com.springboot.crud.service;

import com.springboot.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    @Qualifier("kuberDb")
    private JdbcTemplate jdbcTemplate;

    /*@Autowired
    public EmployeeServiceImpl(@Qualifier("kuberDb") JdbcTemplate primaryJdbcTemplate) {
        this.jdbcTemplate = primaryJdbcTemplate;
    }

    @Transactional(transactionManager = "primaryTransactionManager")
    public void performPrimaryDataOperation() {
        // Perform database operations using primaryJdbcTemplate
    }*/

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try {
            String sql = "select * from Employee where id = ?";
            employee = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class), id);
            return employee;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> list = null;
        String sql = "select * from Employee";
        List<Map<String,Object>> sqlResult = jdbcTemplate.queryForList(sql);

        System.out.println("All employees" +sqlResult);
        list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));

        return list;
    }

    @Override
    public String updateEmployee(Employee employee, int id) {
        Employee updatedEmployee = null;

        updatedEmployee = getEmployeeById(id);
        if (updatedEmployee != null) {
            String sql = "update Employee set name = ?,email = ? where id = ?";
            jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), id);
            return "Employee details Updated Successfully";
        } else {
            return "Employee Details Not Found with this id: " + id;
        }

    }

    @Override
    public String deleteEmployeeById(int id) {
        Employee employee = null;

        employee = getEmployeeById(id);
        if (employee != null) {
            String sql1 = "delete from Employee where id =?";
            jdbcTemplate.update(sql1, id);
            return "Employee record Deleted Successfully with this id: " + id;
        } else {
            return "Employee With this id: " + id + " not Found.";
        }
    }

    @Override
    public String addEmployee(Employee employee) {
        if (employee != null) {
            String sql = "insert into Employee(name,email) values(?,?)";
            int idd = jdbcTemplate.update(sql, employee.getName(), employee.getEmail());
            return "Employee Inserted Successfully";
        } else {
            return "Employee Details Failed to Insert";
        }
    }
}
