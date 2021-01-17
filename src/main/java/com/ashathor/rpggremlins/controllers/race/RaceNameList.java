package com.ashathor.rpggremlins.controllers.race;

import com.ashathor.rpggremlins.models.Race;
import com.ashathor.rpggremlins.repositories.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RaceNameList {

    @Autowired
    private RaceRepository raceRepository;

    public List<Race> getNameList(String name) {
        List<Race> namedRaces = new ArrayList<>();
        for (Race race : raceRepository.findAll()){
            if (race.getName().toLowerCase().contains(name.toLowerCase())){
                namedRaces.add(race);
            }
        }
        return namedRaces;
    }
}
