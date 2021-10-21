package com.ashathor.rpggremlins.repositories.remote;

import com.ashathor.rpggremlins.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findAllByAbilityId(Long id);
}
