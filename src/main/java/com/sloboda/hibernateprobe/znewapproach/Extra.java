package com.sloboda.hibernateprobe.znewapproach;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(onlyExplicitlyIncluded = true)
public class Extra {
    @Id
    @Column(unique = true)
    @ToString.Include
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @Setter(AccessLevel.MODULE)
    private Employee employee;

    @ToString.Include
    @Setter
    private String payload;

    public Extra(String payload) {
        this.payload = payload;
    }

    public void updateBy(Extra extra) {
        this.payload = extra.payload;
    }
}
