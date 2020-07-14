package com.ashathor.rpggremlins.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "race", schema = "rpggremlins")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "race_generator")
    @SequenceGenerator(name="race_generator", sequenceName = "race_id_seq", schema = "rpggremlins")
    @Column(name="id", unique=true, nullable=false)
    private Long id;
    private String name;
    private String lore;
    private String age;
    private String alignment;
    @Column(name="size_text")
    private String sizeText;
    @Column(name="size")
    private String size;
    private int speed;
}
