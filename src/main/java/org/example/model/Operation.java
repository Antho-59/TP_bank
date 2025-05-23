package org.example.model;

public class Operation {

    private  int id;
    private double amount;
    private String opStatut;
    private int accountId;

    public Operation() {
    }

    public Operation(double amount, String opStatut, int accountId) {
        this.amount = amount;
        this.opStatut = opStatut;
        this.accountId = accountId;
    }

    public Operation(int id, double amount, String opStatut, int accountId) {
        this.id = id;
        this.amount = amount;
        this.opStatut = opStatut;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOpStatut() {
        return opStatut;
    }

    public void setOpStatut(String opStatut) {
        this.opStatut = opStatut;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", amount=" + amount +
                ", opStatut='" + opStatut + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
