package com.sloboda.hibernateprobe.znewapproach;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
@Validated
public class EmployeeService {
    private final EntityManager em;
    private final EmployeeRepository repository;
    private final EmployeeServiceAsync employeeServiceAsync;

    public void add(@Valid EmployeeRequest employeeRequest) {
        Employee employee = new Employee(
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getGender(),
                employeeRequest.getBirthDate()
        );
        em.persist(employee);
    }

    public void assignManager(Long employeeId, Long managerId) {
        Employee employee = repository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Employee %d not found", employeeId)));
        Employee manager = repository.findById(managerId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Manager %d not found", managerId)));

        employee.assignManager(manager);

        log.info("members are = " + manager.getSubordinates());
    }

    public void remove(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Employee %d not found", id)));

        repository.deleteById(id);
    }


    @Transactional
    public void method4() throws InterruptedException {
        Employee manager = new Employee("x4", "x4");
        Employee merge = repository.save(manager);

        Employee employee2 = new Employee("y4", "y4");
        repository.save(employee2);

        Thread.sleep(10000);

        //employeeServiceAsync.newMethod(merge);
        employeeServiceAsync.newMethodId(1L);
    }
}
