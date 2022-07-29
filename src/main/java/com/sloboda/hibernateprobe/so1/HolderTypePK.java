package com.sloboda.hibernateprobe.so1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HolderTypePK implements Serializable {
    @NotNull
    @Column(name = "holder_type_code")
    private String holderTypeCode;
}
