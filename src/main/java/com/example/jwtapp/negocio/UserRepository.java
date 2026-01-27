package com.example.jwtapp.negocio;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String,User> usuarios = new HashMap<>();

    public void save(User user) {
        usuarios.putIfAbsent(user.getUsername(),user);
    }

    public User getUserByUsername(String username) {
        return usuarios.get(username);
    }


}
