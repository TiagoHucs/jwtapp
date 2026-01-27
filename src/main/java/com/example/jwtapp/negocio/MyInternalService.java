package com.example.jwtapp.negocio;

import com.example.jwtapp.security.PasswordUtil;
import com.example.jwtapp.security.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyInternalService {

    @Autowired
    UserRepository userRepository;

    MyInternalService(){
        create("admin","123");
    }

    public String hello() {
        String user = UserContext.getUsername();
        return "Endpoint protegido, acessador por " + user + " 😎";
    }

    public void create(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setHashPass(PasswordUtil.hash(password));
        userRepository.save(user);
    }

    public User getByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
