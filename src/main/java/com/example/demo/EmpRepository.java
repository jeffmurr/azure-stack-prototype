package com.example.demo;


import com.example.demo.Emp;
import org.springframework.data.repository.CrudRepository;

public interface EmpRepository extends CrudRepository<Emp, Integer> {
    Emp findByName(String name);
}