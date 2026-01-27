package com.example.jwtapp.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    private static final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder(10); // custo

    public static String hash(String senhaPura) {
        return encoder.encode(senhaPura);
    }

    public static boolean matches(String senhaPura, String hashSalvo) {
        return encoder.matches(senhaPura, hashSalvo);
    }

}
