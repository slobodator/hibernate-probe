package com.sloboda.hibernateprobe.mybatis;

import com.sloboda.hibernateprobe.BaseTest;
import com.sloboda.hibernateprobe.entity.article.Client;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ClientMapperTest extends BaseTest {
    @Autowired
    ClientMapper clientMapper;

    @Test
    public void findAllUsers() {
        List<Client> clients = clientMapper.findAllClients();
        assertNotNull(clients);
    }
}