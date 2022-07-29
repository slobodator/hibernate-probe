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
public class FsetConsolidatedHoldingsPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "fsym_id")
    private String fsymId;
}
