package com.example.samir_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/create")
    public ResponseEntity<BankAccount> createAccount(@RequestParam Long userId,
                                                     @RequestParam String accountHolderName,
                                                     @RequestParam double balance) {
        BankAccount account = bankAccountService.createAccount(userId, accountHolderName, balance);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam Long userId, @RequestParam double amount) {
        String response = bankAccountService.deposit(userId, amount);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam Long userId, @RequestParam double amount) {
        String response = bankAccountService.withdraw(userId, amount);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<BankAccount> getAccountById(@PathVariable Long accountId) {
        BankAccount account = bankAccountService.findAccountById(accountId);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/user/accounts")
    public ResponseEntity<List<BankAccount>> getUserAccounts(@RequestParam Long userId) {
        List<BankAccount> accounts = bankAccountService.getAccountsByUserId(userId);
        return ResponseEntity.ok(accounts);
    }
}