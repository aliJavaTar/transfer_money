package org.example.trasfer.application;

import com.sun.jdi.request.InvalidRequestStateException;
import org.example.trasfer.domain.User;
import org.example.trasfer.domain.Users;

public class AddFriends {

    private final Users users;

    public AddFriends(Users users) {
        this.users = users;
    }

    public void addFriends(Long id, String email) {
        User user = users.findById(id);

        User friend = users.findByEmail(email)
                .orElseThrow(() -> new InvalidRequestStateException("User not found"));

        user.addFriend(friend);

    }
}
