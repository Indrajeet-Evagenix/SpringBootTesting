package com.pdfExample.repository;

import com.pdfExample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

//@EnableJpaRepositories
public interface EmployeeRepository {

    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);
}
