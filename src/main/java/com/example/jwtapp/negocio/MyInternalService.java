package com.example.jwtapp.negocio;

import com.example.jwtapp.security.UserContext;
import org.springframework.stereotype.Service;

@Service
public class MyInternalService {


    public String hello() {
        String user = UserContext.getUsername();
        return "Endpoint protegido, acessador por " + user + " 😎";
    }
}
