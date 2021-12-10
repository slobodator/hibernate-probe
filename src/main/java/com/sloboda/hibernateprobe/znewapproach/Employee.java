package com.sloboda.hibernateprobe.znewapproach;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "employee2")
@Getter
@ToString
public class Employee extends Person  {

    private boolean manager;

    @ManyToOne
    private Employee reportsTo;

    @OneToMany(mappedBy = "reportsTo")
    @ToString.Exclude
    private Set<Employee> subordinates = new TreeSet<>();

    public Employee(String firstName, String lastName) {
        super(firstName, lastName, null, null);
    }

    public Employee(String firstName, String lastName, Gender gender, LocalDate birthDate) {
        super(firstName, lastName, gender, birthDate);
    }

    public Set<Employee> getSubordinates() {
        return Collections.unmodifiableSet(subordinates);
    }

    public void addSubordinate(Employee subordinate) {
        if (subordinates.add(subordinate)) {
            manager = true;

            subordinate.assignManager(this);
        }
    }

    public void assignManager(Employee manager) {
        this.reportsTo = manager;
        manager.addSubordinate(this);
    }

    public void removeSubordinate(Employee subordinate) {
        if (subordinates.remove(subordinate)) {
            manager = subordinates.size() > 0;

            subordinate.unassignManager();
        }
    }

    public void unassignManager() {
        if (this.reportsTo != null) {
            this.reportsTo.removeSubordinate(this);
        }
        this.reportsTo = null;
    }
}
