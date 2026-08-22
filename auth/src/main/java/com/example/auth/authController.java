package com.example.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class authController {

    @GetMapping("/")
    public String h(){
        return "dash";
    }

    @GetMapping("/sign-in")
    public String k() {
        return "login";
    }

}
