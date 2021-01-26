package com.ashathor.rpggremlins.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "blog", schema = "rpggremlins")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Blog {

    private static final Integer HOOK_LENGTH = 140;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_generator")
    @SequenceGenerator(name="blog_generator", sequenceName = "blog_id_seq", schema = "rpggremlins")
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    private String title;
    private String imgLink;
    private String hook;
    private String body;
    private String author;
    @Column(name="date")
    private LocalDateTime dateCreated;
    private Integer likes;


    /*
    * pid SERIAL PRIMARY KEY,
  title VARCHAR(255),
  body VARCHAR,
  user_id INT REFERENCES users(uid),
  author VARCHAR REFERENCES users(username),
  date_created TIMESTAMP
  like_user_id INT[] DEFAULT ARRAY[]::INT[],
  likes INT DEFAULT 0
    * */


}
