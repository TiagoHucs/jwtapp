package com.example.jwtapp.security;

import java.util.logging.Logger;

public final class UserContext {
    private static final Logger log = Logger.getLogger(JwtFilter.class.getName());

    private static final ThreadLocal<String> USERNAME = new ThreadLocal<>();

    private UserContext() {}

    public static void setUsername(String username) {
        USERNAME.set(username);
        log.info("setando usuario " + username +  " no contexto");
    }

    public static String getUsername() {
        log.info("obtendo username");
        return USERNAME.get();
    }

    public static boolean isAuthenticated() {
        return USERNAME.get() != null;
    }

    public static void clear() {
        USERNAME.remove();
        log.info("contexto limpo");
    }
}
