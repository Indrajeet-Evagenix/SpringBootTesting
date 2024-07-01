package com.pdfExample.repository;

import com.pdfExample.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAllEmployee() {
        String sql = "select * from employee";
        List<Employee> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
        return list;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee1 = new Employee();
        String emp_department = "";
        String sql = "select emp_department,emp_name from employee where emp_id = ?";
        List<Map<String, Object>> employee = jdbcTemplate.queryForList(sql, id);
        if (!employee.isEmpty()) {
            for (Map m : employee) {
                if (m.get("emp_department") != null) {
                    emp_department = m.get("emp_department").toString();
                    employee1.setEmpDepartment(emp_department);
                }
                if (m.get("emp_name") != null) {
                    emp_department = m.get("emp_name").toString();
                    employee1.setEmpName(emp_department);
                }
            }
            return employee1;
        } else {
            return null;
        }

    }
}
