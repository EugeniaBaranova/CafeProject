package com.epam.web.builder;

import com.epam.web.entity.Entity;

import java.sql.ResultSet;

public interface Builder<T extends Entity> {

    T build (ResultSet resultSet);
}
