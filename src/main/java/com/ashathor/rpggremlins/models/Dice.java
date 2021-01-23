package com.ashathor.rpggremlins.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "dice", schema = "rpggremlins")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "race_generator")
    //@SequenceGenerator(name="race_generator", sequenceName = "race_id_seq", schema = "rpggremlins")
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    private int diceSides;
}
