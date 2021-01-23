package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.RpgClass;
import com.ashathor.rpggremlins.models.Skill;
import com.ashathor.rpggremlins.models.Skill;
import com.ashathor.rpggremlins.repositories.AbilityRepository;
import com.ashathor.rpggremlins.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/skills")
public class SkillsController {

    @Autowired
    private SkillRepository skillRepository;


    @GetMapping
    public String listSkills(ModelMap modelMap){
        List<Skill> skillsList = skillRepository.findAll();
        List<Skill> skillsListSorted = skillsList.stream().sorted(Comparator.comparing(Skill::getName)).collect(Collectors.toList());
        modelMap.put("skillsList", skillsListSorted);
        return "skill/skills";
    }

    /*@GetMapping("/{id}")
    public Skill get(@PathVariable("id") Long id){
        return skillRepository.getOne(id);
    }

    *//**Find all(List) Skills that use a given ability(index)
     * E.g. /ability/str
     * returns a list of skills that are of the strength ability
     * {Athletics}
     * @param index
     * @return List<Skill>
     * *//*
    *//*@GetMapping("/ability/{index}")
    public List<Skill> get(@PathVariable("index") String index){
        return skillRepository.findAllByAbilityId(abilityRepository.findByIndex(index).getId());
    }*/

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id, ModelMap modelMap) {
        Skill skill = skillRepository.getOne(id);
        modelMap.put("skill", skill);
        return "skill/skill";
    }
}
