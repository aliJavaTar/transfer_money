package org.example.trasfer.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Balance balance;
    private Set<User> friends;

    public User(String username, String password, String email, Balance balance) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = balance;
        this.friends = new HashSet<>();
    }

    public void addFriend(User user) {
        this.friends.add(user);
    }

    public BigDecimal sendMoney(Balance balance, BigDecimal money) {
        return this.balance.addAmount(balance, money);
    }
}
