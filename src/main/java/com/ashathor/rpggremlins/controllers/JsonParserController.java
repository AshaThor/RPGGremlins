package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.business.JsonParcer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({ "/json" })
public class JsonParserController {

    @GetMapping
    private String parce(){
        JsonParcer jsonParcer = new JsonParcer();
        return jsonParcer.run("https://www.dnd5eapi.co/api/classes");

    }
}
