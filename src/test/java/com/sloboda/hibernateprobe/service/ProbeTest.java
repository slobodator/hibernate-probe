package com.sloboda.hibernateprobe.service;

import javax.money.Monetary;
import javax.transaction.Transactional;

import com.sloboda.hibernateprobe.BaseTest;
import com.sloboda.hibernateprobe.entity.Item;
import org.javamoney.moneta.Money;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

@Transactional
@Rollback(false)
public class ProbeTest extends BaseTest {
    @Test
    public void testMoneyUsageDifferentCurrencies() {
        Money tenDollars = Money.of(10, "USD");
        Money oneEuro = Money.of(1, Monetary.getCurrency("EUR"));
        tenDollars.add(oneEuro);
    }

    @Test
    public void testMoneyUsageSameCurrency() {
        Money tenDollars = Money.of(10, "USD");
        Money oneBuck = Money.of(1, Monetary.getCurrency("USD"));
        Money sum = tenDollars.add(oneBuck);
        System.out.println(sum);
    }

    @Test
    public void testMoneyPersistence() {
        Item item = new Item("Mask", Money.of(30, Monetary.getCurrency("UAH")));

        em.persist(item);
    }
}
