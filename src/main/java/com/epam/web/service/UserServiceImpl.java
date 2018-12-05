package com.epam.web.service;

import com.epam.web.entity.User;
import com.epam.web.repository.Repository;
import com.epam.web.repository.RepositoryFactory;
import com.epam.web.repository.specification.UserByLoginAndPasswordSpec;

import java.sql.Connection;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    @Override
    public Optional<User> login(String login, String password){

        ConnectionCreator connectionFactory = new ConnectionCreator();
        Connection connection = connectionFactory.getConnection();

        RepositoryFactory factory = new RepositoryFactory(connection);
        Repository<User> userRepository = factory.getUserRepository();

        return userRepository.queryForSingleResult(new UserByLoginAndPasswordSpec(login, password));
    }
}
