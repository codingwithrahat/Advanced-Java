package com.turtlesltd.dynamicrendering;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexControler {

    @GetMapping("/")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/contact-us")
    public String contactPage(){
        return "contact";
    }

    @PostMapping("/contact-us")
    public String submitForm(@RequestParam String email,
                             @RequestParam (required = false) String pass,
                             @RequestParam String message) {
        IO.println("form Submit from method");

        IO.println("Email : " + email);
        IO.println("Message : " + message);
        return "contact";
    }
}


