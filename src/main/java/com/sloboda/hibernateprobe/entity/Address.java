package com.sloboda.hibernateprobe.entity;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = {"city", "street", "building"})
@ToString(of = {"city", "street", "building"})
public class Address {
    private String city;
    private String street;
    private String building;
}
