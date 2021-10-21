package com.ashathor.rpggremlins.repositories.remote;

import com.ashathor.rpggremlins.models.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepository extends JpaRepository<Ability, Long> {
    Ability findByName(String name);
    Ability findByIndex(String index);
}