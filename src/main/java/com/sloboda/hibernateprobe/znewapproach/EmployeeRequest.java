package com.sloboda.hibernateprobe.znewapproach;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmployeeRequest {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
}
