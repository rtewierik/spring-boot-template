package com.acn.spring.boot.intro.repositories;

import com.acn.spring.boot.intro.models.User;

import java.util.Optional;

public interface UserRepositoryImpl {
    void insertUser(long id, String name, String surname);

    Optional<User> findUserById(long id);

    void deleteUser(long id);
}
