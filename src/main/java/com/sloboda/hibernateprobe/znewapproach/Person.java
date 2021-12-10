package com.sloboda.hibernateprobe.znewapproach;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
@Getter
@ToString
public class Person implements Comparable<Person> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    protected Long id;

    protected String firstName;

    protected String lastName;

    @Convert(converter = Gender.Converter.class)
    protected Gender gender;

    protected LocalDate birthDate;

    public Person(String firstName, String lastName, Gender gender, LocalDate birthDate) {
        this.firstName = Objects.requireNonNull(firstName, "first name is mandatory");
        this.lastName = Objects.requireNonNull(lastName, "last name is mandatory");
        this.gender = gender;
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return 37;
    }

    @Override
    public int compareTo(Person that) {
        return Comparator
                .comparing(Person::getLastName)
                .thenComparing(Person::getFirstName)
                .compare(this, that);
    }
}
