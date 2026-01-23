package com.example.jwtapp.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private MyInternalService myInternalService;

    @GetMapping("/hello")
    public String hello() {
        return myInternalService.hello();
    }

}
