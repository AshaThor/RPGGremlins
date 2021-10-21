package com.ashathor.rpggremlins.repositories.remote;

import com.ashathor.rpggremlins.models.RpgClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RpgClassRepository extends JpaRepository<RpgClass, Long> {
    RpgClass findByName(String name);
}
