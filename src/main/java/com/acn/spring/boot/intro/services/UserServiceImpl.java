package com.acn.spring.boot.intro.services;

import com.acn.spring.boot.intro.models.User;
import com.acn.spring.boot.intro.repositories.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl repository;
    private int currentMaxUserId = 0;

    public UserServiceImpl(@Autowired UserRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public void addUser(String name, String surname) {
        currentMaxUserId++;
        repository.insertUser(currentMaxUserId, name, surname);
        System.out.printf("%s added%n", name);
    }

    @Override
    public void removeUser(long id) {
        Optional<User> user = repository.findUserById(id);
        if (user.isPresent()) {
            repository.deleteUser(id);
            System.out.printf("%s removed%n", user.get().getName());
        } else {
            System.out.println("User not found.");
        }
    }

    @Override
    public Optional<User> getUser(long id) {
        Optional<User> user = repository.findUserById(id);
        if (user.isPresent()) {
            System.out.printf("hello %s%n", user.get().getName());
        } else {
            System.out.println("User not found.");
        }
        return user;
    }
}
