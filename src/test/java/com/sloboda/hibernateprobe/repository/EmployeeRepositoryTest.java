package com.sloboda.hibernateprobe.repository;

import com.sloboda.hibernateprobe.BaseTest;
import com.sloboda.hibernateprobe.entity.Department;
import com.sloboda.hibernateprobe.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeRepositoryTest extends BaseTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void test1() {
        Employee emp = new Employee(
                "John",
                new Department(100L)
        );
        em.persist(emp);

        long count = employeeRepository.count();
        System.out.println("count = " + count);
    }

    @Test
    public void test2() {
        Employee employee = em.find(Employee.class, 1L);

        em.detach(employee);

        Employee copy = employee.setId(null);

        em.merge(copy);

        long count = employeeRepository.count();
        System.out.println("count = " + count);
    }
}

