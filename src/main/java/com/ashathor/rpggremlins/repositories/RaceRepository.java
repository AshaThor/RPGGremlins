package com.ashathor.rpggremlins.repositories;

import com.ashathor.rpggremlins.models.Race;
import com.ashathor.rpggremlins.models.RpgClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {
    Race findByName(String name);
}
