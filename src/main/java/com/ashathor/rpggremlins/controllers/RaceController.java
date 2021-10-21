package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.Race;
import com.ashathor.rpggremlins.repositories.remote.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/v1/races")
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

/*    @Autowired
    private RaceNameList raceNameList;

    @Autowired
    private RaceSpeedList raceSpeedList;*/

    @GetMapping
    public List<Race> listRaces() {
        List<Race> raceList = raceRepository.findAll();
        List<Race> raceListSorted = raceList.stream().sorted(Comparator.comparing(Race::getName)).collect(Collectors.toList());
        return raceListSorted;
    }

    @GetMapping(params = "id")
    @ResponseBody
    public Race getById(@RequestParam Integer id) {
        return raceRepository.findById(id);
    }

    @GetMapping(params = "name")
    @ResponseBody
    public Race getByName(@RequestParam String name) {
        return raceRepository.findByName(name);
    }
    /*
    @GetMapping("/speed/{speed}")
    public List<Race> getListOfRacesBySpeed(@PathVariable("speed") Long speed) {
        return raceSpeedList.getSpeedList(speed);
    }*/

    @GetMapping("/new")
    public String newRaceForm(Model model) {
        model.addAttribute("race", new Race());
        return "race/newrace";
    }



    @GetMapping("/admin")
    public String raceAdmin(ModelMap modelMap) {
        List<Race> racesList = raceRepository.findAll();
        List<Race> racesListSorted = racesList.stream().sorted(Comparator.comparing(Race::getName)).collect(Collectors.toList());
        modelMap.put("racesList", racesListSorted);
        return "race/admin";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Race race) {
        raceRepository.save(race);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public String create(@ModelAttribute Race race, Model model) {
        model.addAttribute("race", race);
        raceRepository.save(race);
        return "race/newsuccess";
    }
}
