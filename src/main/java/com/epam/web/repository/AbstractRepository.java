package com.epam.web.repository;

import com.epam.web.builder.Builder;
import com.epam.web.entity.Entity;
import com.epam.web.repository.specification.Specification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AbstractRepository<T extends Entity> implements Repository<T>{

    private Connection connection;
    private Builder<T> builder;

    public AbstractRepository(Connection connection, Builder<T> builder) {
        this.connection = connection;
        this.builder = builder;
    }


    public List<T> executeQuery(String query, List parameters){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<T> entities = new ArrayList<>();
            while(resultSet.next()){
                T entity = builder.build(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public Optional<T> executeForSingleResult(String query, List parameters){
        List<T> entities = executeQuery(query, parameters);
        if(!entities.isEmpty()){
            T entity = entities.get(0);
            return Optional.of(entity);
        }
        return Optional.empty();
    }


    @Override
    public Optional<T> queryForSingleResult(Specification specification) {
        //TODO
        String query = specification.toSql();
        List parameters = specification.getParameters();

        executeForSingleResult(query, parameters);
        return Optional.empty();
    }

    @Override
    public List<T> query(Specification specification) {
        //TODO
        List parameters = specification.getParameters();
        String query = specification.toSql();
        executeQuery(query, parameters);
        return Collections.emptyList();
    }

}
