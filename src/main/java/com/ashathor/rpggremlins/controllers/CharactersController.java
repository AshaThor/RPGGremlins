package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.Character;
import com.ashathor.rpggremlins.repositories.BlogRepository;
import com.ashathor.rpggremlins.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
public class CharactersController {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharactersController(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @GetMapping
    public List<Character> list(){
        return characterRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Character character){
        characterRepository.save(character);
    }

    @GetMapping("/{id}")
    public Character get(@PathVariable("id") long id){
        return characterRepository.getOne(id);
    }
}
