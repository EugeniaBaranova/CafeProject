package com.epam.web.repository;

import com.epam.web.repository.specification.Specification;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    void add(T object);

    void remove(T object);

    Optional<List<T>> findBy(Specification specification);
}
