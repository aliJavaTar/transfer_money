package org.example.trasfer.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class UserShould {
    @Test
    void sendMoney() {
        BigDecimal AliIsAmount = new BigDecimal("100.00");
        Balance AlisBalance = new Balance(AliIsAmount);

        BigDecimal YaserIsAmount = new BigDecimal("00.00");
        Balance YaserBalance = new Balance(YaserIsAmount);


        User ali = new User("ali", "1234", "ali77@gmail.com", AlisBalance);

        User yaser = new User("yaser", "1234", "yaser@gmail.com", YaserBalance);

//        ali.sendMoney(yaser, AlisBalance);


    }
}