package com.ashathor.rpggremlins.repositories.remote;

import com.ashathor.rpggremlins.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    Character findByName(String name);
}