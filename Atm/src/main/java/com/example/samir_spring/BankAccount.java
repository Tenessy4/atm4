package com.example.samir_spring;

public class BankAccount {

    private Long accountId;
    private String accountHolderName;
    private double balance;

    public BankAccount() {}

    public BankAccount(Long accountId, String accountHolderName, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс не может быть отрицательным.");
        }
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс не может быть отрицательным.");
        }
        this.balance = balance;
    }
}