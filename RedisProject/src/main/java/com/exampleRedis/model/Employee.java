package com.exampleRedis.model;

import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Employee")
public class Employee implements Serializable {

    private String id;
    private String name;
    private String email;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Employee() {
    }

    public Employee(String  id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
