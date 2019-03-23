package com.sloboda.hibernateprobe;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.qos.logback.classic.Level;
import lombok.extern.slf4j.Slf4j;
import net.ttddyy.dsproxy.QueryCountHolder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public abstract class BaseTest {
    @PersistenceContext
    protected EntityManager em;

    @BeforeEach
    void setUp() {
        ((ch.qos.logback.classic.Logger) LoggerFactory.getLogger("net.ttddyy")).setLevel(Level.DEBUG);
        QueryCountHolder.clear();
    }

    @AfterEach
    public void tearDown() {
        long totalCount = QueryCountHolder.getGrandTotal().getTotal();
        System.out.println("\nTOTAL LOG COUNT = " + totalCount);
    }
}
