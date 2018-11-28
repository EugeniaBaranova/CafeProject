package com.epam.web.service;

import com.epam.web.entity.User;
import com.epam.web.repository.Repository;
import com.epam.web.repository.UserRepository;
import com.epam.web.repository.specification.UserByLoginAndPasswordSpec;

import java.util.Optional;

public class UserServiceImpl {

    public Optional<User> login(String login, String password){
        Repository<User> repository = new UserRepository();
        Optional<User> user = repository.queryForSingleResult(new UserByLoginAndPasswordSpec(login, password));
        return user;
    }
}
