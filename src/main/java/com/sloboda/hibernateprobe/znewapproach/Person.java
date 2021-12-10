package com.sloboda.hibernateprobe.znewapproach;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@Getter
@ToString
@EqualsAndHashCode
public class Person implements Comparable<Person> {
    private String firstName;

    private String lastName;

    @Convert(converter = Gender.Converter.class)
    private Gender gender;

    private LocalDate birthDate;

    public Person(String firstName, String lastName, Gender gender, LocalDate birthDate) {
        this.firstName = Objects.requireNonNull(firstName, "first name is mandatory");
        this.lastName = Objects.requireNonNull(lastName, "last name is mandatory");
        this.gender = gender;
        this.birthDate = birthDate;
    }

    @Override
    public int compareTo(Person that) {
        return Comparator
                .comparing(Person::getLastName)
                .thenComparing(Person::getFirstName)
                .compare(this, that);
    }
}
