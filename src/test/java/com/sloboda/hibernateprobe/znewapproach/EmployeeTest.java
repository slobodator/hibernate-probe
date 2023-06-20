package com.sloboda.hibernateprobe.znewapproach;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class EmployeeTest {
    @Test
    void equals() {
        Employee x = new Employee("x", "x");
        Employee y = new Employee("y", "y");

        assertThat(x, Matchers.not(equalTo(y)));
    }


}