package com.epam.web.repository;

import com.epam.web.repository.specification.Specification;

import java.util.List;
import java.util.Optional;

public interface Repository<Entity> {

    Optional<Entity> queryForSingleResult(Specification specification);

    Optional<List<Entity>> query(String string);

}
