package com.sloboda.hibernateprobe.znewapproach;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @MapsId
    @OneToOne
    private Employee employee;

    public Country(String countryName, Employee employee) {
        this.name = countryName;
        this.employee = employee;
    }
}
