package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.Ability;
import com.ashathor.rpggremlins.repositories.remote.AbilityRepository;
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

    @GetMapping(params = "name")
    @ResponseBody
    public Ability getByName(@RequestParam String name) {
        return abilityRepository.findByName(name);
    }

    @GetMapping(params = "index")
    @ResponseBody
    public Ability getByIndex(@RequestParam(required = false) String index) {
        return abilityRepository.findByIndex(index);
    }

    @GetMapping(params = "id")
    public Ability getById(@RequestParam Long id){
        return abilityRepository.getOne(id);
    }
}
