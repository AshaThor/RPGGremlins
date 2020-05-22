package com.ashathor.rpggremlins.repositories;

import com.ashathor.rpggremlins.models.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepository extends JpaRepository<Ability, Long> {
    Ability findByIndex(String index);
}
