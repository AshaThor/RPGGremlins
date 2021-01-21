package com.ashathor.rpggremlins.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "blog", schema = "rpggremlins")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Blog {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "race_generator")
    //@SequenceGenerator(name="race_generator", sequenceName = "race_id_seq", schema = "rpggremlins")
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    private String title;
    private String img;
    private String hook;
    private String body;
    private String author;
    private Date date_created;
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
