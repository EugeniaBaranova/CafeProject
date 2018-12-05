package com.epam.web.repository;

import com.epam.web.builder.UserBuilder;
import com.epam.web.entity.User;
import com.epam.web.repository.specification.Specification;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserRepository extends AbstractRepository<User> {


    public UserRepository(Connection connection) {
        super(connection, new UserBuilder());
    }

    public Optional<User> queryForSingleResult(Specification specification){
        super.queryForSingleResult(specification);
        return Optional.empty();
    }

    public List<User> query(Specification specification){
        super.query(specification);
        return Collections.emptyList();
    }
}
