package com.sloboda.hibernateprobe.regularapproach;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "is_manager")
    private Boolean manager;

    @ManyToOne
    @JoinColumn(name = "reports_to")
    private EmployeeEntity reportsTo;

    @OneToMany(mappedBy = "reportsTo")
    @ToString.Exclude
    private List<EmployeeEntity> subordinaries;
}
