package com.ashathor.rpggremlins.controllers.race;

import com.ashathor.rpggremlins.models.Race;
import com.ashathor.rpggremlins.repositories.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/races")
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private RaceNameList raceNameList;

    @Autowired
    private RaceSpeedList raceSpeedList;

    @GetMapping
    public List<Race> list(){ return raceRepository.findAll(); }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Race race){ raceRepository.save(race);
    }

    @GetMapping("/{id}")
    public Race getById(@PathVariable("id") long id){
        return raceRepository.getOne(id);
    }

    @GetMapping("/name/{name}")
    public List<Race> getListOfRacesByName(@PathVariable("name") String name) {
        return raceNameList.getNameList(name);
    }

    @GetMapping("/speed/{speed}")
    public List<Race> getListOfRacesBySpeed(@PathVariable("speed") Long speed) {
        return raceSpeedList.getSpeedList(speed);
    }

    }