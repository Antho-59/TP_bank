package org.example.service;


import org.example.dao.CustomerDAO;
import org.example.model.Customer;
import org.example.util.DbManager;
import java.sql.Connection;
import java.sql.SQLException;

public class CustomerService {

    private CustomerDAO customerDAO;
    private Connection connection;


    public CustomerService() {
        try {
            connection = new DbManager().getConnection();
            customerDAO = new CustomerDAO(connection);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Customer createCustomer(String firstName, String lastName, String phone){
        Customer customer = new Customer(firstName,lastName,phone);
        try {
            if(customerDAO.add(customer)){
                return customer;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return customer;
    }
    public boolean updateCustomer(Customer customer){
        try {
            if(customerDAO.update(customer)){
                return true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public Customer getCustomer(int id){
        try {
            return customerDAO.get(id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean deleteCustomer(int id){  // TOdo Supr les comptes liés
        Customer customer = null;
        try {
            customer = customerDAO.get(id);
            if(customer != null){
                return customerDAO.delete(customer);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
