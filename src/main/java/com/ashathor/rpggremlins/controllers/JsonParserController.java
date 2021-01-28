package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.business.DndAPIJsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({ "/json" })
public class JsonParserController {

    @GetMapping
    public String parce(){
        DndAPIJsonParser jsonParcer = new DndAPIJsonParser();
        return jsonParcer.run("https://www.dnd5eapi.co/api/classes");

    }
}
