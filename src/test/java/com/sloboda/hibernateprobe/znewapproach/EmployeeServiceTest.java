package com.sloboda.hibernateprobe.znewapproach;

import com.sloboda.hibernateprobe.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

class EmployeeServiceTest extends BaseTest {
    @Autowired
    private EmployeeService service;

    @Test
    void add1() {
        service.add(
                new EmployeeRequest()
                        .setFirstName("Adam")
                        .setLastName("Alpha")
                        .setGender(Gender.DIVERSE)
                        .setBirthDate(LocalDate.of(2000, 1,1))
        );
    }

    @Test
    void add2() {
        service.add(
                new EmployeeRequest()
                        .setFirstName("Ben")
                        .setLastName("Bravo")
        );
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

}