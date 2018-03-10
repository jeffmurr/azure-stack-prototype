package com.example.demo;

import com.example.demo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@EnableCaching
@RestController

public class EmpRepositoryController {
    @Autowired
    private EmpRepository empRepository;
    
    @RequestMapping(method=RequestMethod.GET, value="/emps")
    @Cacheable("allemp")
    public Iterable<Emp> emp() {
        return empRepository.findAll();
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/emps/{id}")
    @Cacheable("empsbydeptid")
    public Emp show(@PathVariable Integer id) {
    	return empRepository.findOne(id);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/emps")
    @Cacheable("empspost")
    public String save(@RequestBody Emp emp) {
        empRepository.save(emp);
        return emp.getName();
    }
}
