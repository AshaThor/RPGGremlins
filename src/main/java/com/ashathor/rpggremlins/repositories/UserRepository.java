package com.ashathor.rpggremlins.repositories;

import com.ashathor.rpggremlins.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
