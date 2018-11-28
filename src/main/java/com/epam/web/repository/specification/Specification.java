package com.epam.web.repository.specification;

public interface Specification<T> {

    boolean specified(T object);
}
