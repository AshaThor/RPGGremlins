package com.ashathor.rpggremlins.repositories.remote;

import com.ashathor.rpggremlins.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {
    Race findById(Integer id);
    Race findByName(String name);
}
