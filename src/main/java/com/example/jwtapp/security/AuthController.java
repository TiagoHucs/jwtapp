package com.example.jwtapp.security;

import com.example.jwtapp.negocio.MyInternalService;
import com.example.jwtapp.negocio.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;
    private MyInternalService myInternalService;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        // 🔥 Exemplo simples (mock)
        if (validate(username,password)) {
            return jwtUtil.gerarToken(username);
        }

        throw new RuntimeException("Usuário ou senha inválidos");
    }

    private boolean validate(String username, String password){
        User user = myInternalService.getByUsername(username);
        if (null == user){
            throw new RuntimeException("Usuario nao encontrado");
        }
        return PasswordUtil.matches(password,user.getHashPass());
    }
}
