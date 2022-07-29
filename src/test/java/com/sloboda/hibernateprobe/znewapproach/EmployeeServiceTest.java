package com.sloboda.hibernateprobe.znewapproach;

import com.sloboda.hibernateprobe.BaseTest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
class EmployeeServiceTest extends BaseTest {
    @Autowired
    private EmployeeService service;

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private Validator validator;

    @Test
    void add1() {
        service.add(
                new EmployeeRequest()
                        .setFirstName("Adam")
                        .setLastName("Alpha")
                        .setGender(Gender.DIVERSE)
                        .setBirthDate(LocalDate.of(2000, 1, 1))
        );
    }

    @Test
    void add2() {
        Set<?> validate = validator.validate(
                        List.of(
                                new EmployeeRequest()
                                        .setFirstName("Ben")
                                        .setLastName("Bravo")
                        )
        );
        assertThat(validate.size()).isGreaterThan(0);
    }

    @Test
    void assignManager() {
        service.assignManager(1L, 2L);
    }

    @Test
    void add3() {
        service.add(
                new EmployeeRequest()
        );
    }

    @Test
    void managerAndSubordinate() {
        Employee employee = new Employee("John", "Employee");
        employee.assignManager(
                new Employee("Jack", "Manager")
        );
        em.persist(employee);
    }

    @Test
    void feedback() {
        Employee manager = new Employee("x", "x");
        em.persist(manager);

        Employee employee = new Employee("y", "y");

        manager.addSubordinate(employee);

        manager.putFeedback(employee, "Good enough");
    }

    @Test
    void name() {
        Employee manager = new Employee("x", "x");
        em.persist(manager);

        Employee employee = new Employee("y", "y");

        manager.assignManager(employee);

        em.flush();
        em.clear();

        Employee employee1 = em.find(Employee.class, manager.getId());
        System.out.println("manager = " + employee1.getReportsTo());
    }

    @Test
    void name2() {
        Employee manager = new Employee("x", "x");
        em.persist(manager);

        manager.setExtra(new Extra("abc"));

        em.flush();
        em.clear();

        Employee employee1 = em.find(Employee.class, manager.getId());
        System.out.println("manager = " + employee1.getExtra());

        employee1.setExtra(new Extra("xyz"));

        em.flush();
        em.clear();

        Employee employee2 = em.find(Employee.class, manager.getId());
        System.out.println("manager = " + employee2.getExtra());

        //employee2.setExtra(null);
    }

    @Test
    void name3() {
        Employee manager = new Employee("x", "x");
        Employee merge = em.merge(manager);

        em.flush();

        System.out.println("merge = " + merge.getId());
        em.clear();

        Employee employee1 = em.find(Employee.class, 1L);
        System.out.println("manager = " + employee1);
    }

    @Test
    void name4() throws InterruptedException {
        service.method4();

        Thread.sleep(1000L);
    }

    @Test
    void name5() {
        Employee manager = new Employee("x", "x");
        Employee merge = em.merge(manager);

        em.flush();

        //service.newMethodId(merge.getId());


        System.out.println(merge);
    }

    @Test
    void testuuid() {
        UUID.fromString("asd");
    }

    @RequiredArgsConstructor
    private static class Employees {
        @Valid
        private final List<EmployeeRequest> employees;
    }

    @Test
    void name11() {
        em.persist(
                new Employee(
                        "first", "last", Gender.MALE, LocalDate.now(), Map.of(Request.BALCONY, RequestImportance.NICE_TO_HAVE)
                )
        );
    }
}