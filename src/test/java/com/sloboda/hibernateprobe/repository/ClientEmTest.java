package com.sloboda.hibernateprobe.repository;

import com.sloboda.hibernateprobe.BaseTest;
import com.sloboda.hibernateprobe.entity.article.Client;
import org.junit.Test;

/**
 * @author BMW Group
 */
public class ClientEmTest extends BaseTest {
    @Test
    public void friends() {
        Client a = new Client("a", "a");
        Client b = new Client("b", "b");
        a.addFriend(b);

        em.persist(a);
    }
}
