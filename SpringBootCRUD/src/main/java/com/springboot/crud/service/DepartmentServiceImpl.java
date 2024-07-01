package com.springboot.crud.service;

import com.springboot.crud.entity.Department;
import com.springboot.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    @Qualifier("kuberDb1")
    private JdbcTemplate jdbcTemplate;

    /*@Autowired
    public DepartmentServiceImpl(@Qualifier("kuberDb1") JdbcTemplate secondaryJdbcTemplate) {
        this.jdbcTemplate = secondaryJdbcTemplate;
    }*/

    /*@Transactional(transactionManager = "secondaryTransactionManager")
    public void performSecondaryDataOperation() {
        // Perform database operations using secondaryJdbcTemplate
    }*/

    @Override
    public Department getDepartmentById(int id) {
        Department department = null;
        try {
            String sql = "select * from department where id = ?";
//            List<Map<String,Object>> sqlResult = jdbcTemplate.queryForList(sql);
            department = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Department.class), id);
            return department;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Department> getAllDepartment() {
        List<Department> list = null;
        String sql = "select * from department";
        List<Map<String,Object>> sqlResult = jdbcTemplate.queryForList(sql);

        System.out.println("All employees" +sqlResult);
        list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Department.class));

        return list;
    }

    @Override
    public String addDepartment(Department department) {
        if (department != null) {
            String sql = "insert into department(dept_name) values(?)";
            int idd = jdbcTemplate.update(sql, department.getDept_name());
            return "Department Inserted Successfully";
        } else {
            return "Department Details Failed to Insert";
        }
    }

    @Override
    public String updateDepartment(Department department, int id) {
        Department updatedEmployee = null;

        updatedEmployee = getDepartmentById(id);
        if (updatedEmployee != null) {
            String sql = "update department set dept_name = ? where id = ?";
            jdbcTemplate.update(sql, department.getDept_name(), id);
            return "Department details Updated Successfully";
        } else {
            return "Department Details Not Found with this id: " + id;
        }
    }

    @Override
    public String deleteDepartment(int id) {
        Department department = null;
        department = getDepartmentById(id);
        if (department != null) {
            String sql1 = "delete from department where id =?";
            jdbcTemplate.update(sql1, id);
            return "Department record Deleted Successfully with this id: " + id;
        } else {
            return "Department With this id: " + id + " not Found.";
        }
    }
}
