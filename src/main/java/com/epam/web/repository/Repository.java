package com.epam.web.repository;

import com.epam.web.entity.Entity;
import com.epam.web.repository.specification.Specification;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends Entity> {

    Optional<T> queryForSingleResult(Specification specification);

    Optional<List<T>> query(String string);

}
