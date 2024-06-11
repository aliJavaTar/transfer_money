package org.example.trasfer.application;

import com.sun.jdi.request.InvalidRequestStateException;
import org.example.trasfer.domain.User;
import org.example.trasfer.domain.Users;
import org.example.trasfer.presentation.request.TransferRequest;

public class TransferMoney {
    private final Users users;

    public TransferMoney(Users users) {
        this.users = users;
    }

    public void transferMoney(TransferRequest request) {
        User user = users.findById(request.getUserId());

        User friend = users.findByEmail(request.getEmail())
                .orElseThrow(() -> new InvalidRequestStateException("User not found"));

        if (!user.getFriends().contains(friend)) {
            throw new InvalidRequestStateException("User is not friend");
        }

//        user.sendMoney(friend, request.getAmount());
    }
}
