package org.example.dao;

import org.example.model.BankAccount;
import org.example.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BankAccountDAO extends BaseDAO<BankAccount> {
    public BankAccountDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean add(BankAccount element) throws SQLException {
        request = "INSERT INTO bankAccount (customer_id) values (?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1,element.getCustomerId());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(BankAccount element) throws SQLException {
        return false; //on ne peux pas changer la propriété d'un compte client
    }

    @Override
    public boolean delete(BankAccount element) throws SQLException {
        request = "DELETE from bankAccount where id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public BankAccount get(int id) throws SQLException {
        BankAccount bankAccount = null;
        request = "SELECT * FROM bankAccount where id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            bankAccount = new BankAccount(resultSet.getInt(1));
    }

return bankAccount;

}}

