package com.sloboda.hibernateprobe.regularapproach;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
@Getter
public class UserRequest {
    @Id
    private Long id;

    private String firstName;

    private String lastName;
}
