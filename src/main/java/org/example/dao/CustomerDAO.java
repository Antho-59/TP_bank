package org.example.dao;

import org.example.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerDAO extends BaseDAO<Customer>{
    protected CustomerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean add(Customer element) throws SQLException {
        request = "INSERT INTO customer (first_name,last_name,phone) values (?,?,?)";
        statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,element.getFirstName());
        statement.setString(2,element.getLastName());
        statement.setString(3,element.getPhone());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(Customer element) throws SQLException {
        request = "UPDATE customer set first_name = ?, last_name = ?, phone = ?, where id = ?";
        statement = connection.prepareStatement(request);
        statement.setString(1,element.getFirstName());
        statement.setString(2,element.getLastName());
        statement.setString(3,element.getPhone());
        statement.setInt(4,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(Customer element) throws SQLException {
        request = "DELETE from customer where id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }



    @Override
    public Customer get(int id) throws SQLException {
        Customer customer = null;
        request = "SELECT * FROM customer where id = ?";
        statement = connection.prepareStatement(request);
        statement.setInt(1,id);
        resultSet = statement.executeQuery();
        if (resultSet.next()){
            customer = new Customer(resultSet.getInt("id"), // TODO BUG ici pas compris
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"));
        }
        return customer;
    }




}
