package com.sloboda.hibernateprobe.regularapproach;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Optional;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(onlyExplicitlyIncluded = true)
@Setter
public class User {
    @Id
    @ToString.Include
    private Long id;

    @ToString.Include
    private String firstName;

    @ToString.Include
    private String lastName;

    private String description;

    public User(String firstName, String lastName) {
        this.firstName = Objects.requireNonNull(firstName, "first name can't be null");
        this.lastName = Objects.requireNonNull(lastName, "last name can't be null");
    }

    public User(String first, String last, String desc) {
        this.firstName = first;
        this.lastName = last;
        this.description = desc;
    }

    public void update(String firstName, String lastName) {

    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User that = (User) o;
        return id != null && id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

/*
    public UserResponse toResponse() {
        return new UserResponse(
                this.firstName,
                this.lastName
        );
    }
*/
}
