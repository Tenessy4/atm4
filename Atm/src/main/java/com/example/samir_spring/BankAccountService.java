package com.example.samir_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BankAccountService {

    @Autowired
    private UserService userService; // Inject UserService

    private Long currentAccountId = 1L;

    public BankAccount createAccount(Long userId, String accountHolderName, double balance) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь с ID " + userId + " не найден.");
        }
        BankAccount account = new BankAccount(currentAccountId++, accountHolderName, balance);
        user.getAccounts().add(account);
        return account;
    }

    public String deposit(Long userId, double amount) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь с ID " + userId + " не найден.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной.");
        }

        if (user.getAccounts().isEmpty()) {
            throw new IllegalArgumentException("У пользователя нет счетов.");
        }

        // Deposit to the first account (simplification)
        BankAccount account = user.getAccounts().get(0);
        account.setBalance(account.getBalance() + amount);
        return "Сумма " + amount + " успешно зачислена.";
    }

    public String withdraw(Long userId, double amount) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь с ID " + userId + " не найден.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть положительной.");
        }

        if (user.getAccounts().isEmpty()) {
            throw new IllegalArgumentException("У пользователя нет счетов.");
        }

        // Withdraw from the first account with sufficient balance
        for (BankAccount account : user.getAccounts()) {
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                return "Снятие " + amount + " успешно выполнено.";
            }
        }

        throw new IllegalArgumentException("Недостаточно средств.");
    }

    public List<BankAccount> getAccountsByUserId(Long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь с ID " + userId + " не найден.");
        }
        return user.getAccounts();
    }

    public BankAccount findAccountById(Long accountId) {
        // Get all users and search through their accounts
        List<User> allUsers = userService.getAllUsers();
        return allUsers.stream()
                .flatMap(user -> user.getAccounts().stream())
                .filter(account -> account.getAccountId().equals(accountId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + accountId));
    }
}