package com.sloboda.hibernateprobe.regularapproach;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EmployeeEntityService {
    private final EmployeeEntityRepository repository;

    public void add(EmployeeRequest employeeRequest) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(employeeRequest.getFirstName());
        repository.save(employeeEntity);
    }

    public void assignManager(Long employeeId, Long managerId) {
        EmployeeEntity employeeEntity = repository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Employee %d not found", employeeId)));
        EmployeeEntity managerEntity = repository.findById(managerId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Manager %d not found", managerId)));

        employeeEntity.setReportsTo(managerEntity);

        log.info("members are = " + managerEntity.getSubordinaries());
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
