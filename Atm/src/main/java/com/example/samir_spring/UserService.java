package com.example.samir_spring;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final Map<Long, User> users = new HashMap<>();
    private Long currentUserId = 1L;

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(Long userId) {
        return users.get(userId);
    }

    public User createUser(String name) {
        User user = new User(currentUserId++, name);
        users.put(user.getId(), user);
        return user;
    }

    public void blockUser(Long userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь с ID " + userId + " не найден.");
        }
        user.setBlocked(true);
    }

    public void unblockUser(Long userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("Пользователь с ID " + userId + " не найден.");
        }
        user.setBlocked(false);
    }
}