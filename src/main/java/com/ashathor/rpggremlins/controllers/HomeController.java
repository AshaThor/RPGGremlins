package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.controllers.race.RaceController;
import com.ashathor.rpggremlins.models.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/", "/home" })
public class HomeController {
    @Autowired
    private RaceController raceController;

    @GetMapping
    public String main(Model model){
        //model.addAttribute("race", raceController.getListOfRacesByName("Dragonborn"));
        return "home";
    }
}
