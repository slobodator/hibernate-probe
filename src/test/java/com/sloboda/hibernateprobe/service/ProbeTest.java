package com.sloboda.hibernateprobe.service;

import javax.transaction.Transactional;

import com.sloboda.hibernateprobe.BaseTest;
import com.sloboda.hibernateprobe.entity.Client;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

@Transactional
@Rollback(false)
public class ProbeTest extends BaseTest {
    @Test
    public void testColumnNullability() {
        Client client = new Client();
        client.setFirstName(null);
        client.setLastName(null);

        em.persist(client);
    }
}
