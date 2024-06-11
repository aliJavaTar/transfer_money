package org.example.trasfer.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class Balance {
    private BigDecimal amount;

    public Balance() {
    }

    public Balance(BigDecimal amount) {
        this.amount = amount;
    }


    public BigDecimal addAmount(Balance balance, BigDecimal money) {
        // * 5 % 100
        BigDecimal divide = this.amount.multiply(new BigDecimal(5))
                .divide(new BigDecimal(100), RoundingMode.HALF_UP);

        if (!(divide.compareTo(balance.getAmount()) >= 0)) {
            throw new IllegalArgumentException("Cannot add an amount that isn't enough");
        }
        BigDecimal moneyAdd = this.amount.subtract(money);
        BigDecimal test = balance.amount.add(moneyAdd);
        this.amount.subtract(divide);
        return test;
    }
}
