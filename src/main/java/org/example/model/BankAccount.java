package org.example.model;

public class BankAccount {

    private int id;
    private int customerId;

    public BankAccount() {
    }

    public BankAccount(int customerId) {
        this.customerId = customerId;
    }

    public BankAccount(int id, int customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", customerId=" + customerId +
                '}';
    }
}
