package com.epam.web.repository.specification;

import com.epam.web.entity.User;

public class UserByLoginAndPasswordSpec implements Specification<User> {

    private String login;
    private String password;

    public UserByLoginAndPasswordSpec(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean specified(User object) {
        return false;
    }
}
