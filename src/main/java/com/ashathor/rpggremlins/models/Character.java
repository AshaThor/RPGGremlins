package com.ashathor.rpggremlins.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {
    private String name;
    private String charClass;
    private String race;
    private int level;
    private String player;

    public Character() {
    }

}
