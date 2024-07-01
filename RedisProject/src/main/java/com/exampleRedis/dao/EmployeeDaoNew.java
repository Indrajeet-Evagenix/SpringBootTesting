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
public class EmployeeDaoNew {

    @Autowired
    @Qualifier("redisWithNormalMap")
    private RedisTemplate<String, Object> redisTemplateNew;

    @Resource(name = "redisWithNormalMap")
    private HashOperations<String, String, Employee> hashOperations;

    private static final String KEY = "EMPLOYEE";

    public Employee saveEmployee(Employee employee) {
//        hashOperations.putIfAbsent(KEY, employee.getId(), employee);
        redisTemplateNew.opsForSet().add("11",employee.getName(),"1");
        return employee;
    }

    /*public String getEmployee(String id) {
        return (String) redisTemplate.opsForHash().get(KEY, id);
    }

    public Map<Object, Object> findAll() {
        return redisTemplate.opsForHash().entries(KEY);
    }

    public void delete(String id) {
        redisTemplate.opsForHash().delete(KEY, id);
    }*/

}
