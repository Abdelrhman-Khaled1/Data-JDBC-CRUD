package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	
//	@Autowired  OR
	private EmployeeRepo employeeRepo;
	@Autowired
	public EmployeeController(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@GetMapping("/count")
	public long countEmp() {
		return employeeRepo.count();
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		return employeeRepo.findById(id).get();
	}
	
	@GetMapping("")
	public Iterable<Employee> findAll(){
		return employeeRepo.findAll();
	}
	
	@GetMapping("/insert")
	public Employee addEmp() {
		
		return employeeRepo.save(new Employee("insert",2502.3));
	}
	
	@GetMapping("/update")
	public Employee updateEmp() {
		
		return employeeRepo.save(new Employee(44L,"update",44444.4));
	}
	
	@GetMapping("/filter/{name}")
	public List<Employee> filter(@PathVariable String name){
		return employeeRepo.findByName(name);
	}
}
