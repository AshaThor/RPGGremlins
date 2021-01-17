package com.ashathor.rpggremlins.repositories;

import com.ashathor.rpggremlins.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {}