package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.Ability;
import com.ashathor.rpggremlins.repositories.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/abilities")
public class AbilityController {

    private final AbilityRepository abilityRepository;

    @Autowired
    public AbilityController(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }

    @GetMapping
    public List<Ability> listAll(){
        return abilityRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ability getById(@PathVariable("id") Long id){
        return abilityRepository.getOne(id);
    }

    //@GetMapping("/index/{index}")
    //public Ability getByIndex(@PathVariable("index") String index){
        //return abilityRepository.findByIndex(index);
    //}
}
