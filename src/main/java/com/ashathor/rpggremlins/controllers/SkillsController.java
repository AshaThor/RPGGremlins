package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.Ability;
import com.ashathor.rpggremlins.models.Skill;
import com.ashathor.rpggremlins.repositories.AbilityRepository;
import com.ashathor.rpggremlins.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skills")
public class SkillsController {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private AbilityRepository abilityRepository;

    @GetMapping
    public List<Skill> list(){
        return skillRepository.findAll();
    }

    @GetMapping("/{id}")
    public Skill get(@PathVariable("id") Long id){
        return skillRepository.getOne(id);
    }

    /**Find all(List) Skills that use a given ability(index)
     * E.g. /ability/str
     * returns a list of skills that are of the strength ability
     * {Athletics}
     * @param index
     * @return List<Skill>
     * */
    @GetMapping("/ability/{index}")
    public List<Skill> get(@PathVariable("index") String index){
        return skillRepository.findAllByAbilityId(abilityRepository.findByIndex(index).getId());
    }
}
