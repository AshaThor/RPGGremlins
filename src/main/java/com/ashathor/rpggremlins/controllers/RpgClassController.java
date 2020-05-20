package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.RpgClass;
import com.ashathor.rpggremlins.repositories.RpgClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rpgclass")
public class RpgClassController {

    @Autowired
    private RpgClassRepository rpgClassRepository;

    @GetMapping
    public List<RpgClass> list(){
        return rpgClassRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody RpgClass rpgClass){
        rpgClassRepository.save(rpgClass);
    }

    @GetMapping("/{id}")
    public RpgClass get(@PathVariable("id") long id){
        return rpgClassRepository.getOne(id);
    }
}
