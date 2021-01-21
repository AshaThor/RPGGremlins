package com.ashathor.rpggremlins.controllers.race;

import com.ashathor.rpggremlins.models.Race;
import com.ashathor.rpggremlins.models.RpgClass;
import com.ashathor.rpggremlins.repositories.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/races")
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private RaceNameList raceNameList;

    @Autowired
    private RaceSpeedList raceSpeedList;

    @GetMapping
    public String listRaces(ModelMap modelMap){
        List<Race> raceList = raceRepository.findAll();
        List<Race> raceListSorted = raceList.stream().sorted(Comparator.comparing(Race::getName)).collect(Collectors.toList());
        modelMap.put("raceList", raceListSorted);
        return "race/races"; }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Race race){ raceRepository.save(race);
    }

    @GetMapping("/{id}")
    public String getByID(@PathVariable("id") long id, ModelMap modelMap) {
        Race race = raceRepository.getOne(id);
        modelMap.put("race", race);
        return "race/race";
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