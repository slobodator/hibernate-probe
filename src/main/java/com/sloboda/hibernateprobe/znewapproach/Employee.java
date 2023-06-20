package com.sloboda.hibernateprobe.znewapproach;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

@SuppressWarnings("FieldMayBeFinal")
@NamedEntityGraph(
        name = "with-country",
        attributeNodes = {
                @NamedAttributeNode("country"),
        },
        includeAllAttributes = true

)

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

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Country country;

    @Basic(fetch = FetchType.LAZY)
    private String description = "description";

    public Employee(String firstName, String lastName) {
        this.person = new Person(firstName, lastName, null, null);
    }

    public Employee(String firstName, String lastName, String countryName) {
        this.person = new Person(firstName, lastName, null, null);
        this.country = new Country(countryName, this);
    }

    public Employee(String firstName, String lastName, Gender gender, LocalDate birthDate) {
        this.person = new Person(firstName, lastName, gender, birthDate);
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

    public void printCountry() {
        System.out.println(country);
    }
}
