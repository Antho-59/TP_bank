package org.example.dao;

import org.example.model.Customer;
import org.example.model.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OperationDAO extends BaseDAO<Operation> {
    protected OperationDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean add(Operation element) throws SQLException {
        request = "INSERT INTO operation (customer_id) values (?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1,element.getAmount());
        statement.setString(2,element.getOpStatut());
        statement.setInt(3,element.getAccountId());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(Operation element) throws SQLException {
        request = "UPDATE operation set amount = ?, opstatut = ?, account_id = ?, where id = ?";
        statement = connection.prepareStatement(request);
        statement.setDouble(1,element.getAmount());
        statement.setString(2,element.getOpStatut());
        statement.setInt(3,element.getAccountId());
        statement.setInt(4,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(Operation element) throws SQLException {
        request = "DELETE from operation where id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public Operation get(int id) throws SQLException {
        Operation operation = null;
        request = "SELECT * FROM operation where id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            operation = new Operation(resultSet.getDouble("amount"),
                    resultSet.getString("opstatut"),
                    resultSet.getInt("id"));
        }
        return operation;
    }
}
