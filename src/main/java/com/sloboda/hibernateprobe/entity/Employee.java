package com.sloboda.hibernateprobe.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@SuppressWarnings("unused")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Setter
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }
}
