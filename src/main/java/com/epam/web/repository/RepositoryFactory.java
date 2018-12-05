package com.epam.web.repository;


import com.epam.web.entity.User;

import java.sql.Connection;

public class RepositoryFactory implements AutoCloseable{

    private Connection connection;

    public RepositoryFactory(Connection connection) {
        this.connection = connection;
    }

    public Repository<User> getUserRepository(){
        return new UserRepository(connection);
    }

    @Override
    public void close() throws Exception {
        //?
        connection.close();
    }
}
