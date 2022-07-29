package com.sloboda.hibernateprobe.so1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "holder_type", schema = "mket_data")
@Inheritance
public class HolderType {
    @EmbeddedId
    private HolderTypePK holderTypeCode;

    @Column(name = "holder_type_description")
    private LocalDate holderTypeDescription;

    @Column(name = "created_by")
    private String createdBy;
}