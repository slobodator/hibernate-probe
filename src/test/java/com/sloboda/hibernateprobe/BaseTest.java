package com.sloboda.hibernateprobe;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
public abstract class BaseTest {
    @PersistenceContext
    protected EntityManager em;
}
