package com.sloboda.hibernateprobe.entity;

import com.sloboda.hibernateprobe.entity.Department;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
