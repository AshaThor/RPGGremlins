package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.Race;
import com.ashathor.rpggremlins.models.RpgClass;
import com.ashathor.rpggremlins.repositories.RaceRepository;
import com.ashathor.rpggremlins.repositories.RpgClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/races")
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

    @GetMapping
    public List<Race> list(){
        return raceRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Race race){
        raceRepository.save(race);
    }

    @GetMapping("/{id}")
    public Race get(@PathVariable("id") long id){
        return raceRepository.getOne(id);
    }

    //try to get param name working
    public Race getClass(@RequestParam(value="name") String name) {
        return raceRepository.findByName(name);
    }
}
