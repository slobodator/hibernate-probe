package com.sloboda.hibernateprobe.entity.article;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author BMW Group
 */
public class ClientTest {

    @Test
    public void addFriend() {
        Client a = new Client("a", "a");
        Client b = new Client("b", "b");
        a.addFriend(b);

        assertThat(a.getFriends().size(), equalTo(1));
        assertThat(b.getFriends().size(), equalTo(1));
    }
}