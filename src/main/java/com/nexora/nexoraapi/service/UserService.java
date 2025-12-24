package com.nexora.nexoraapi.service;

import com.nexora.nexoraapi.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserService {

    private final List<User> users = new ArrayList<>();

    public User createUser(User user){
        users.add(user);
        return user;
    }

    public List<User> getAllUsers(){
        return users;
    }

    public User getUserById(int id){
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public User updateUser(int id, User updatedUser){
        User existingUser = getUserById(id);
        if(existingUser != null){
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
        }

        return existingUser;
    }

    public boolean deleteUser(int id){
        return users.removeIf(u -> u.getId() == id);
    }


}
