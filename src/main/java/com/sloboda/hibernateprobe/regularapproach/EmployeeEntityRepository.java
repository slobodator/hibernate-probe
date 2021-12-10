package com.sloboda.hibernateprobe.regularapproach;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeEntityRepository extends CrudRepository<EmployeeEntity, Long> {
}
