package com.acn.spring.boot.intro.repositories;

import com.acn.spring.boot.intro.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepository implements UserRepositoryImpl {

    private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public void insertUser(long id, String name, String surname) {
        if (users.stream().noneMatch(u -> u.getId() == id)) {
            User user = new User(id, name, surname);
            users.add(user);
        }
    }

    @Override
    public Optional<User> findUserById(long id) {
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public void deleteUser(long id) {
        Optional<User> user = findUserById(id);
        user.ifPresent(users::remove);
    }
}
