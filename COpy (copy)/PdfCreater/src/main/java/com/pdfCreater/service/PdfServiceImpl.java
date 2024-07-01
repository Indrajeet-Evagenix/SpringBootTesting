package com.pdfCreater.service;

import com.pdfCreater.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class PdfServiceImpl implements PdfService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getAllEmployee() {
        String sql = "select * from employee12;";
        List<Map<String ,Object>> listMap = jdbcTemplate.queryForList(sql);
        List<Employee> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
        if (!list.isEmpty()) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = new Employee();
        String sql = "select first_name,last_name from employee12 where id= ?";

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, id);
        if (!list.isEmpty()) {
            for (Map map : list) {
                if (map.get("first_name") != null) {
                    employee.setFirstName(map.get("first_name").toString());
                }
                if (map.get("last_name") != null) {
                    employee.setLastName(map.get("last_name").toString());
                }
            }
            return employee;
        } else {
            return null;
        }
    }
}
