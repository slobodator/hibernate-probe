package com.sloboda.hibernateprobe.entity.article;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@EqualsAndHashCode(of = {"firstName", "lastName"})
@ToString(of = {"firstName", "lastName"})
@Entity
@NoArgsConstructor
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Setter
    @Column(length = 32, nullable = false)
    private String firstName;

    @Column(length = 32, nullable = false)
    private String lastName;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "client_friends",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private Set<Client> friends = new HashSet<>();

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Set<Client> getFriends() {
        return Collections.unmodifiableSet(friends);
    }

    public void addFriend(Client friend) {
        if (friends.add(friend)) {
            friend.addFriend(this);
        }
    }
}
