package com.epam.web.repository.specification;

import com.epam.web.entity.User;

public class FindByLoginSpecification implements Specification<User> {
    @Override
    public boolean specified(User object) {
        return false;
    }
}
