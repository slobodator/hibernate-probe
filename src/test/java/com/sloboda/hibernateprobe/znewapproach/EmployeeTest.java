package com.sloboda.hibernateprobe.znewapproach;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class EmployeeTest {
    @Test
    void equals() {
        Employee x = new Employee("x", "x");
        Employee y = new Employee("y", "y");

        assertThat(x, Matchers.not(equalTo(y)));
    }


    @Test
    void managerScenario() {
        Employee man = new Employee("x", "x");
        Employee e1 = new Employee("y", "y");
        Employee e2 = new Employee("z", "z");

        e1.assignManager(man);

        assertThat(man.isManager(), equalTo(true));
        assertThat(man.getSubordinates(), hasItem(e1));

        man.addSubordinate(e2);
        assertThat(man.getSubordinates(), hasItem(e2));

        e2.unassignManager();
        assertThat(e2.getReportsTo(), nullValue());
        assertThat(man.isManager(), equalTo(true));
        assertThat(man.getSubordinates(), hasSize(1));


        man.removeSubordinate(e1);
        assertThat(man.isManager(), equalTo(false));
        assertThat(man.getSubordinates(), hasSize(0));

        assertThat(e1.getReportsTo(), nullValue());
    }

    @Test
    void nulls() {
        new Employee(null, null);
    }
}