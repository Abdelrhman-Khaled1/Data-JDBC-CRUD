package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;
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

//	@RequestMapping(method = RequestMethod.GET , path = "/count")
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
	
	@PostMapping("")
	public Employee addEmp(@RequestBody Employee emp) {
		return employeeRepo.save(emp);
	}
	
	@PutMapping("")
	public Employee updateEmp(@RequestBody Employee emp ) {
		return employeeRepo.save(emp);
	}
	
	@GetMapping("/filter/{name}")
	public List<Employee> filter(@PathVariable String name){
		return employeeRepo.findByName(name);
	}
	
	@GetMapping("/filter")
	public List<Employee> filterWithSalary(@RequestParam String name,@RequestParam double salary){
		return employeeRepo.findByNameAndSalary(name,salary);
	}
	
	@DeleteMapping("/{empId}")
	public void deleteEmp(@PathVariable("empId") Long id ) {
		 employeeRepo.deleteById(id);
	}
}
