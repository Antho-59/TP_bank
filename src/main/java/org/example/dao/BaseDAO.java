package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class BaseDAO<T> {

    // <T> = generique

    protected Connection connection;
    protected PreparedStatement statement;
    protected String request;
    protected ResultSet resultSet;


    protected BaseDAO(Connection connection){
        this.connection = connection;
    }

    public abstract boolean add(T element) throws SQLException;
    public abstract boolean update(T element) throws SQLException;
    public abstract boolean delete(T element) throws SQLException;
    public abstract T get(int id) throws SQLException;


}