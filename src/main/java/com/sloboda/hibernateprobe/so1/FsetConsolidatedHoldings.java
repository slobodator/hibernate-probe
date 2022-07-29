package com.sloboda.hibernateprobe.so1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fset_consolidated_holdings", schema = "mket_data")
public class FsetConsolidatedHoldings extends HolderType {

    private static final long serialVersionUID = 1L;

/*
    @EmbeddedId
    private FsetConsolidatedHoldingsPK id;
*/

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "fset_proper_name")
    private String fProperName;
}