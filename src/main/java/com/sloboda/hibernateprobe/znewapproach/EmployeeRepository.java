package com.sloboda.hibernateprobe.znewapproach;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @EntityGraph(value = "with-country", type = EntityGraph.EntityGraphType.FETCH)
    @Query("select e from Employee e where e.id = :id")
    Optional<Employee> findByIdWithCountry(@Param("id") long id);
}
