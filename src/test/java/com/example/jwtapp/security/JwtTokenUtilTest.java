package com.example.jwtapp.security;


import io.jsonwebtoken.Claims;
import org.junit.Assert;
import org.junit.Test;

public class JwtTokenUtilTest {

    @Test
    public void basicTest(){
        String token = JwtUtil.generateToken("usuario123");
        System.out.println("Token: " + token);
        Claims claims = JwtUtil.validateToken(token);
        System.out.println("Usuário: " + claims.getSubject());
        System.out.println("Expiration: " + claims.getExpiration());
    }

    @Test
    public void getUsernameFromToken() {
        String token = JwtUtil.generateToken("usuario123");
        Claims claims = JwtUtil.validateToken(token);
        Assert.assertEquals("usuario123",claims.getSubject());
    }

    @Test
    public void getExpirationDateFromToken() {
        String token = JwtUtil.generateToken("usuario123");
        Claims claims = JwtUtil.validateToken(token);
        Assert.assertEquals("espiration",claims.getExpiration());
    }

    @Test
    public void generateToken() {
        String token = JwtUtil.generateToken("usuario123");
        String[] arr = token.split("\\.");
        Assert.assertEquals(3,arr.length);
    }

    @Test
    public void validateToken() {
    }

    @Test
    public void canTokenBeRefreshed() {
    }

    @Test
    public void refreshToken() {
    }
}