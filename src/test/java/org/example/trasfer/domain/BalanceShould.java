package org.example.trasfer.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class BalanceShould {


    @Test
    void canAddAmountToBalance() {

        Balance aliBalance = new Balance(new BigDecimal("100.00"));

        Balance yaserBalance = new Balance(new BigDecimal("20"));

        aliBalance.addAmount(yaserBalance, new BigDecimal("30"));

        Assertions.assertEquals(yaserBalance.getAmount(), new BigDecimal("50"));
    }

}