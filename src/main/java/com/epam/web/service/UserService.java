package com.epam.web.service;

import com.epam.web.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> login(String login, String password);
}
