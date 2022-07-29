package com.sloboda.hibernateprobe.znewapproach;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManager;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
@Validated
public class EmployeeServiceAsync {
    private final EntityManager em;
    private final EmployeeRepository repository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Async
    public void newMethodId(Long id) {
        log.info("new MethodId started");
        Employee employee = repository.findById(id).orElseThrow();
        employee.setExtra(new Extra("new extra id"));
        employee.setDesc("new method id");
        log.info("new MethodId finished");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Async
    public void newMethod(Employee employee) {
        log.info("new Method started");
        Employee update = repository.findById(employee.getId()).orElseThrow(
                () -> new RuntimeException("First")
        );
        update.setExtra(new Extra("new extra"));
        update.setDesc("desc");

        repository.findById(2L).orElseThrow(
                () -> new RuntimeException("second")
        );

        log.info("new Method finished");
    }
}
