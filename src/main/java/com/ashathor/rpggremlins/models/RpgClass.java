package com.ashathor.rpggremlins.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "class", schema = "rpggremlins")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RpgClass {

    @Id
    @SequenceGenerator(name="class_generator", sequenceName = "class_id_seq", schema = "rpggremlins")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "class_generator")
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    private String name;
    private int hitDice;
    private int characterSkillsLimit;
    private String lore;
}
