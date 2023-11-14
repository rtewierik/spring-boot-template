package com.acn.spring.boot.intro.services;

import com.acn.spring.boot.intro.models.User;

import java.util.Optional;

public interface UserService {
    void addUser(String name, String surname);

    void removeUser(long id);

    Optional<User> getUser(long id);
}
