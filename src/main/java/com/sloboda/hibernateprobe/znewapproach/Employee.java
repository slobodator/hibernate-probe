package com.sloboda.hibernateprobe.znewapproach;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "employee2")
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Employee implements Comparable<Employee> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @NotBlank
    private String lastName;

    private boolean manager;

    @ManyToOne
    private Employee reportsTo;

    @OneToMany(mappedBy = "reportsTo")
    @ToString.Exclude
    private Set<Employee> subordinates = new TreeSet<>();

    public Employee(String firstName, String lastName) {
        this.firstName = Objects.requireNonNull(firstName, "first name is mandatory");
        this.lastName = Objects.requireNonNull(lastName, "last name is mandatory");
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

    @Override
    public int compareTo(Employee that) {
        return Comparator
                .comparing(Employee::getLastName)
                .thenComparing(Employee::getFirstName)
                .compare(this, that);
    }
}
