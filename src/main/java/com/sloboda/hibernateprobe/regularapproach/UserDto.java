package com.sloboda.hibernateprobe.regularapproach;

import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String lastName;

    private String fistName;

    private String description;

/*

    public UserResponse(User user) {
        this(
                user.getFirstName(),
                user.getLastName()
        );
    }
*/
}
