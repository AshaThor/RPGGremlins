package com.ashathor.rpggremlins.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "character", schema = "rpggremlins")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Character {
    /*Entity class for an RPG Character
    * */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "character_generator")
    @SequenceGenerator(name="character_generator", sequenceName = "character_id_seq", schema = "rpggremlins")
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    private String name;
    private String charClass;
    private String race;
    private int level;
    private String player;

}
