package com.example.samir_spring;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    private String name;
    private boolean blocked;
    private List<BankAccount> accounts;

    public User() {
        // Initialize accounts list in default constructor
        this.accounts = new ArrayList<>();
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
        this.blocked = false;
        // Initialize accounts list in parameterized constructor
        this.accounts = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    // Helper method to add an account
    public void addAccount(BankAccount account) {
        if (this.accounts == null) {
            this.accounts = new ArrayList<>();
        }
        this.accounts.add(account);
    }

    // Helper method to check if user has any accounts
    public boolean hasAccounts() {
        return this.accounts != null && !this.accounts.isEmpty();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blocked=" + blocked +
                ", accountCount=" + (accounts != null ? accounts.size() : 0) +
                '}';
    }
}