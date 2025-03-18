package com.example.samir_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestParam String name) {
        User user = userService.createUser(name);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/user/{id}/block")
    public ResponseEntity<String> blockUser(@PathVariable Long id) {
        userService.blockUser(id);
        return ResponseEntity.ok("Пользователь " + id + " заблокирован.");
    }

    @PutMapping("/user/{id}/unblock")
    public ResponseEntity<String> unblockUser(@PathVariable Long id) {
        userService.unblockUser(id);
        return ResponseEntity.ok("Пользователь " + id + " разблокирован.");
    }
}