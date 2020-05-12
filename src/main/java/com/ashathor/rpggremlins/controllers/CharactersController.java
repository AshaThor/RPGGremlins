package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.Character;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
public class CharactersController {
    @GetMapping
    public List<Character> list(){
        List<Character> characters = new ArrayList<>();
        return characters;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Character character){

    }
    @GetMapping("/{id}")
    public Character get(@PathVariable("id") long id){
        return new Character();
    }
}
