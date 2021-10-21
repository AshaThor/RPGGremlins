package com.ashathor.rpggremlins.controllers.race;

import com.ashathor.rpggremlins.models.Race;
import com.ashathor.rpggremlins.repositories.remote.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RaceSpeedList {
    @Autowired
    private RaceRepository raceRepository;

    public List<Race> getSpeedList(Long speed){
        List<Race> listOfRaces = raceRepository.findAll();
        List<Race> selectedRacesOfSpeed = new ArrayList<>();
        for (Race race : listOfRaces){
            if (race.getSpeed() == speed){
                selectedRacesOfSpeed.add(race);
            }
        }
        return selectedRacesOfSpeed;
    }
}
