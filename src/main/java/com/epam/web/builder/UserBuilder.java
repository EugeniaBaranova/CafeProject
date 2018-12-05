package com.epam.web.builder;

import com.epam.web.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder implements Builder<User> {

    @Override
    public User build(ResultSet resultSet) {
        try {
            String name = resultSet.getString("name");
            String role = resultSet.getString("role");
            return new User(name, role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
