package com.sloboda.hibernateprobe.repository;

import com.sloboda.hibernateprobe.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
