package com.sloboda.hibernateprobe.znewapproach;

import com.sloboda.hibernateprobe.BaseTest;
import io.hypersistence.utils.jdbc.validator.SQLStatementCountValidator;
import net.ttddyy.dsproxy.QueryCountHolder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static io.hypersistence.utils.jdbc.validator.SQLStatementCountValidator.assertSelectCount;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class EmployeeServiceTest extends BaseTest {
    @Autowired
    private EmployeeService service;

    @Autowired
    private EmployeeRepository repository;

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
        service.add(
                new EmployeeRequest()
                        .setFirstName("Ben")
                        .setLastName("Bravo")
        );
    }


    @Test
    void add3() {
        service.add(
                new EmployeeRequest()
        );
    }

    @Test
    void managerAndSubordinate() {
        QueryCountHolder.clear();
        SQLStatementCountValidator.reset();

        Employee employee = new Employee("John", "Employee");
        em.persist(employee);

        em.flush();
        em.clear();


        //em.createQuery("select e from Employee e where e.id = :id", Employee.class).setParameter("id", 1L).getSingleResult();
        //Employee employee1 = em.find(Employee.class, 1L);
        Employee employee1 = repository.findByIdWithCountry(1L).orElseThrow();
        employee1.printCountry();
        employee1.getDescription();

        //System.out.println(QueryCountHolder.get("dataSource").getSelect());
        assertSelectCount(1);
        assertThat(QueryCountHolder.getGrandTotal().getSelect()).isEqualTo(1);

    }


    @Test
    void fetch() {
        Employee employee = em.find(Employee.class, 1L);

    }

    @Test
    void feedback() {
        Employee manager = new Employee("x", "x");
        em.persist(manager);

        Employee employee = new Employee("y", "y");

    }

}