package com.sloboda.hibernateprobe.entity.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.javamoney.moneta.Money;

@Getter
@EqualsAndHashCode(of = "name")
@ToString(of = {"name", "price"})
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 32)
    private String name;

    @Columns(
            columns = {
                    @Column(name = "price_currency", length = 3, nullable = false),
                    @Column(name = "price_amount", precision = 7, scale = 2, nullable = false)
            }
    )
    @Type(type = "org.jadira.usertype.moneyandcurrency.moneta.PersistentMoneyAmountAndCurrency")
    private Money price;

    public Item(String name, Money price) {
        this.name = name;
        this.price = price;
    }
}
