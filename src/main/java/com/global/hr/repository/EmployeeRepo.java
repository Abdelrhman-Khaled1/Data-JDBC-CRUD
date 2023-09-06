package com.global.hr.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long>{
	public List<Employee> findByName(String name);
//	public List<Employee> findByNameAndSalary(.....); Wow
}
