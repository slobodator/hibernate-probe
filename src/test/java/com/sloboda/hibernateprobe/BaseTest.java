package com.sloboda.hibernateprobe;

import lombok.extern.slf4j.Slf4j;
import net.ttddyy.dsproxy.QueryCountHolder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public abstract class BaseTest {
    @PersistenceContext
    protected EntityManager em;

    @BeforeEach
    public void setUp() {
        QueryCountHolder.clear();
    }

    @AfterEach
    public void tearDown() {
        long totalCount = QueryCountHolder.getGrandTotal().getTotal();
        log.info("\nTOTAL LOG COUNT = " + totalCount);
    }
}
