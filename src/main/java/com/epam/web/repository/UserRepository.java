package com.epam.web.repository;

import com.epam.web.entity.User;
import com.epam.web.repository.specification.Specification;

import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository<User> {

    public Optional<User> queryForSingleResult(Specification specification){
        return Optional.empty();
    }

    public Optional<List<User>> query(String string){
        return Optional.empty();
    }
}
