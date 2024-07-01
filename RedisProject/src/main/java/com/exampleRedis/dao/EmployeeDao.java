package com.exampleRedis.dao;

import com.exampleRedis.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

@Repository
public class EmployeeDao {

    @Autowired
    @Qualifier("redisWithMap")
    private RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "EMPLOYEE";

    public Employee saveEmployee(Employee employee) {
        redisTemplate.opsForHash().put(KEY, employee.getId(), employee.getName());

        return employee;
    }

    public String getEmployee(String id) {
        return (String) redisTemplate.opsForHash().get(KEY, id);
    }

    public Map<Object, Object> findAll() {
        return redisTemplate.opsForHash().entries(KEY);
    }

    public void delete(String id) {
        redisTemplate.opsForHash().delete(KEY, id);
    }

}
