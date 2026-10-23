
package com.example.clickNbuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.clickNbuy.dto.UserDto;

@Controller
public class ViewController {

    @GetMapping("/")
    public String loadHome() {
        return "home";
    }

    @GetMapping("/login")
    public String loadLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String loadRegister(UserDto userDto) {
        return "register";
    }
}
