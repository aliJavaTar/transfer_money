package org.example.trasfer.application;

import org.example.trasfer.domain.Balance;
import org.example.trasfer.domain.User;
import org.example.trasfer.domain.Users;
import org.example.trasfer.presentation.request.TransferRequest;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

class TransferMoneyShould {
    Users users;

    void canTransferMoneyForYourSelfAndFriends() {

        Users userRepository = Mockito.mock(Users.class);

        Balance balance = new Balance(new BigDecimal("100"));
        User user = new User("ali", "1234", "ali77@gmail.com", balance);
        Mockito.when(userRepository.findById(any())).thenReturn(user);

        Balance balance1 = new Balance(new BigDecimal("30"));
        User userFind = new User("yaser", "1234", "yaser@gmail.com", balance1);

        Mockito.when(userRepository.findByEmail(any())).thenReturn(Optional.of(userFind));
        TransferMoney transferMoney = new TransferMoney(users);
        TransferRequest request = new TransferRequest();
        transferMoney.transferMoney(request);
    }

}