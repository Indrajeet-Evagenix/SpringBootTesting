package com.springboot.crud.service;

import com.springboot.crud.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department getDepartmentById(int id);

    List<Department> getAllDepartment();

    String addDepartment(Department department);

    String updateDepartment(Department department,int id);

    String deleteDepartment(int id);
}
