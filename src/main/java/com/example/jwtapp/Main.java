package com.example.jwtapp;

import com.example.jwtapp.security.JwtUtil;
import io.jsonwebtoken.Claims;

public class Main {

    public static void main(String[] args) {

        String token = JwtUtil.generateToken("usuario123");
        System.out.println("Token: " + token);
        Claims claims = JwtUtil.validateToken(token);
        System.out.println("Usuário: " + claims.getSubject());

    }

}
