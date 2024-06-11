package org.example.trasfer.application;

import org.example.trasfer.domain.Balance;
import org.example.trasfer.domain.User;
import org.example.trasfer.domain.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;

class UserShould {

    Users users;

    @Test
    void canAddFriend() {
        Users userRepository = Mockito.mock(Users.class);

        User user = new User("ali", "1234", "ali77@gmail.com", new Balance());
        Mockito.when(userRepository.findById(any())).thenReturn(user);

        User userFind = new User("yaser", "1234", "yaser@gmail.com", new Balance());

        Mockito.when(userRepository.findByEmail(any())).thenReturn(Optional.of(userFind));

        AddFriends addFriends = new AddFriends(userRepository);

        addFriends.addFriends(1L, "yaser@gmail.com");

        Assertions.assertTrue(user.getFriends().contains(userFind));



    }
}