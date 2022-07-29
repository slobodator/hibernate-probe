package com.sloboda.hibernateprobe.regularapproach;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel(description = "User Representation Response")
public class UserResponse {
    @ApiModelProperty("Number identifier")
    private Long id;

    @ApiModelProperty("First name")
    private String lastName;

    @ApiModelProperty("Long name")
    private String firstName;

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
