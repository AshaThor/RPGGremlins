package com.ashathor.rpggremlins.repositories.remote;

import com.ashathor.rpggremlins.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
