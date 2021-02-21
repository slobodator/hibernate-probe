package com.sloboda.hibernateprobe.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostDetails {
    @Setter
    @Id
    private Long id;

    @MapsId
    @OneToOne
    @Setter
    private Post post;

    private String text;

    public PostDetails(String text) {
        this.text = text;
    }
}
