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

        BigDecimal multiplyValue = this.amount.multiply(new BigDecimal(5));

        BigDecimal divide = multiplyValue.divide(new BigDecimal(100), RoundingMode.HALF_UP);

        BigDecimal afterSubtractFivePercentDivide = this.amount.subtract(divide);

        if (!(afterSubtractFivePercentDivide.compareTo(balance.getAmount()) >= 0)) {
            throw new IllegalArgumentException("Cannot add an amount that isn't enough");
        }

        BigDecimal afterSubtractMoneyTransferee = this.amount.subtract(money);

        balance.amount = balance.amount.add(money);

        this.amount = afterSubtractMoneyTransferee.subtract(afterSubtractFivePercentDivide);

        return balance.amount;
    }
}
