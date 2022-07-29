package com.sloboda.hibernateprobe.znewapproach;

import lombok.*;
import org.hibernate.annotations.MapKeyType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "employee2")
@Getter
@ToString
public class Employee implements Comparable<Employee> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Person person;

    private boolean manager;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee reportsTo;

    @OneToMany(mappedBy = "reportsTo", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<Employee> subordinates = new TreeSet<>();

    @ElementCollection
    @CollectionTable(
            name = "manager_feedbacks",
            joinColumns = @JoinColumn(name = "manager_id")
    )
    @MapKeyJoinColumn(name = "employee_id") // employee
    @Column(name = "feedback")
    private Map<Employee, String> feedbacks = new HashMap<>();

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Extra extra;

    @Setter
    private String desc;

    @ElementCollection
    @CollectionTable(
            name = "guests_requests",
            joinColumns = @JoinColumn(name = "rsrv_id")
    )
    @MapKeyColumn(name = "request_n")
    @Column(name = "request_importance_n")
    @Enumerated(EnumType.STRING)
    private Map<Request, RequestImportance> guestsRequests = new HashMap<>();

    public Employee(String firstName, String lastName) {
        this.person = new Person(firstName, lastName, null, null);
    }

    public Employee(String firstName, String lastName, Gender gender, LocalDate birthDate) {
        this.person = new Person(firstName, lastName, gender, birthDate);
    }

    public Employee(String firstName, String lastName, Gender gender, LocalDate birthDate, Map<Request, RequestImportance> map) {
        this.person = new Person(firstName, lastName, gender, birthDate);
        guestsRequests.putAll(map);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return 37;
    }

    @Override
    public int compareTo(Employee that) {
        return Comparator.comparing(Employee::getPerson)
                .compare(this, that);
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

    public void putFeedback(Employee employee, String feedback) {
        feedbacks.put(employee, feedback);
    }

    public void setExtra(Extra extra) {
        if (this.extra == null) {
            this.extra = extra;
            this.extra.setEmployee(this);
        } else {
            this.extra.updateBy(extra);
        }
    }

    public void dropExtra() {
        this.extra = null;
    }
}
