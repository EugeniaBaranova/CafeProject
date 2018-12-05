package com.epam.web.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionCreator {

    private static final ConnectionCreator instance = new ConnectionCreator();

    private static final int CONNECTION_POOL_SIZE = 10;
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:8080/cafe_project";

    private boolean initialized;

    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();

    private ConnectionCreator(){}

    private static ConnectionCreator getInstance(){
        return instance;
    }

    public void create() {
        try {
            if (!initialized) {
                Class.forName("com.mysql.jdbc.Driver");


                connectionPool = new ArrayList<>(CONNECTION_POOL_SIZE);
                for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
                    connectionPool.add(createConnection(URL, USER, PASSWORD));
                }


                //????
                initialized = true;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public boolean returnConnection(Connection connection) {
        try {
            if (connection != null) {
                if (connectionPool.size() < CONNECTION_POOL_SIZE) {
                    connectionPool.add(connection);
                    return usedConnections.remove(connection);
                }
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }


    private Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
