package com.example.jwtapp.security;

import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestParam String user,
                        @RequestParam String password) {

        // 🔥 Exemplo simples (mock)
        if ("admin".equals(user) && "123".equals(password)) {
            return jwtUtil.gerarToken(user);
        }

        throw new RuntimeException("Usuário ou senha inválidos");
    }
}
