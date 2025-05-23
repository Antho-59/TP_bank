package org.example.service;

import org.example.dao.BankAccountDAO;
import org.example.dao.CustomerDAO;
import org.example.model.BankAccount;
import org.example.model.Customer;
import org.example.util.DbManager;

import java.sql.Connection;
import java.sql.SQLException;

public class BankAccountService {

    private BankAccountDAO bankAccountDAO;
    private Connection connection;

    public BankAccountService() {
        try {
            connection = new DbManager().getConnection();
            bankAccountDAO = new BankAccountDAO(connection);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean createAccount(Customer customer) {
        BankAccount bankAccount = new BankAccount(customer.getId());
        try {
            if (bankAccountDAO.add(bankAccount)) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public BankAccount getAccount(int id){
        try {
            return BankAccountDAO.get(id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
