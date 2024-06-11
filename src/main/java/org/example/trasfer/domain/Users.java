package org.example.trasfer.domain;

import java.util.Optional;

public interface Users {
    Optional<User> findByEmail(String Email);

    User create(User user);

    User findById(Long id);
}
