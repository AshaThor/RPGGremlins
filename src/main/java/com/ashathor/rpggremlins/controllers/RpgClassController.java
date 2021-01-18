package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.RpgClass;
import com.ashathor.rpggremlins.repositories.RpgClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rpgclasses")
public class RpgClassController {

    @Autowired
    private RpgClassRepository rpgClassRepository;

    public List<RpgClass> list(){
        return rpgClassRepository.findAll();
    }

    public RpgClassController(RpgClassRepository rpgClassRepository){
        this.rpgClassRepository = rpgClassRepository;
    }
    @GetMapping
    public String listClasses(ModelMap modelMap) {
        List<RpgClass> rpgClassesList = rpgClassRepository.findAll();
        modelMap.put("rpgClassesList", rpgClassesList);
        return "rpgclasses";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody RpgClass rpgClass){
        rpgClassRepository.save(rpgClass);
    }

    @GetMapping("/{id}")
    public String get(@PathVariable("id") long id, ModelMap modelMap){
        RpgClass rpgClass = rpgClassRepository.getOne(id);
        modelMap.put("rpgClass", rpgClass);
        return "rpgclass";
    }

    //try to get param name working
    public RpgClass getClass(@RequestParam(value="name") String name) {
        return rpgClassRepository.findByName(name);
    }
}
