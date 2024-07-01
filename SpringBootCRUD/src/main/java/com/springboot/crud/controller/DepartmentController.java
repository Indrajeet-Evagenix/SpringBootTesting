package com.springboot.crud.controller;

import com.springboot.crud.entity.Department;
import com.springboot.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
        Department department = null;
        department = departmentService.getDepartmentById(id);
        if (department != null) {
            return new ResponseEntity<>(department, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(department, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/department/create")
    public ResponseEntity<String> addDepartment(@RequestBody Department department) {
        String result = departmentService.addDepartment(department);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/department")
    public List<Department> getAllDepartment() {
        List<Department> list = null;
        list = departmentService.getAllDepartment();
        return list;
    }

    @PutMapping("/department/{id}")
    public ResponseEntity<String> updateDepartmentById(@PathVariable int id, @RequestBody Department department) {
        String str = departmentService.updateDepartment(department, id);
        return new ResponseEntity<>(str, HttpStatus.OK);

    }

    @DeleteMapping("/department/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable int id) {
        String str = departmentService.deleteDepartment(id);
        return new ResponseEntity<>(str, HttpStatus.ACCEPTED);

    }
}
