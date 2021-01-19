package com.ashathor.rpggremlins.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping({"/home", "/"})
    public String index() {
        return "home";
    }

}
