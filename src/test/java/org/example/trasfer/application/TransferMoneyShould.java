package org.example.trasfer.application;

import org.example.trasfer.domain.Users;
import org.example.trasfer.presentation.request.TransferRequest;

class TransferMoneyShould {
    Users users;

    void canTransferMoneyForYourSelfAndFriends() {

        TransferMoney transferMoney = new TransferMoney(users);
        TransferRequest request = new TransferRequest();
        transferMoney.transferMoney(request);
    }

}