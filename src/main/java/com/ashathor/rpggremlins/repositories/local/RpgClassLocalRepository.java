package com.ashathor.rpggremlins.repositories.local;

import com.ashathor.rpggremlins.models.RpgClass;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RpgClassLocalRepository {

    public RpgClass getOne(long id) {
        return ALL_RPGCLASSES.get((int) id);
    }

    public RpgClass findByName(String name){
        int rpgClassIndex = 99;
        for(int index = 0; index < ALL_RPGCLASSES.size(); index++)
            if (ALL_RPGCLASSES.get(index).getName() == name){
                rpgClassIndex = index;
                index = ALL_RPGCLASSES.size()+1;
            }
        return ALL_RPGCLASSES.get(rpgClassIndex);
    }
    public List<RpgClass> findAll() {
        return ALL_RPGCLASSES;
    }

    private final List<RpgClass> ALL_RPGCLASSES = new ArrayList<>(Arrays.asList(
            new RpgClass(1L, "Artificer", 8, 2,
                    "Masters of invention, artificers use ingenuity and magic to unlock extraordinary capabilities in objects."),
            new RpgClass(2L, "Barbarian", 12, 2,
            "A fierce warrior of primative background who can enter a battle rage"),
            new RpgClass(3L, "Bard", 8, 3,
            "An inspiring magician whose power echoes the music of creation"),
            new RpgClass(4L, "Cleric", 8, 2,
               "A priestly champion who wields divine magic in service of a higher power"),
            new RpgClass(5L, "Druid", 8, 2,
               "A priest of the Old Faith, wielding the powers of nature moonlight and plant growth, fire and lightning and adopting animal forms"),
            new RpgClass(6L, "Fighter", 10, 2,
               "A master of martial combat, skilled with a variety of weapons and armor"),
            new RpgClass(7L, "Monk", 8, 2,
               "An master of martial arts, harnessing the power of the body in pursuit of physical and spiritual perfection"),
            new RpgClass(8L, "Paladin", 10, 2, "A holy warrior bound to a sacred oath"),
            new RpgClass(9L, "Ranger", 10, 3,
               "A warrior who uses martial prowess and nature magic to combat threats on the edges of civilization"),
            new RpgClass(10L, "Rogue", 8, 4,
               "A scoundrel who uses stealth and trickery to overcome obstacles and enemies"),
            new RpgClass(11L, "Sorcerer", 6, 2,
               "A spellcaster who draws on inherent magic from a gift or bloodline"),
            new RpgClass(12L, "Warlock", 8, 2,
               "A wielder of magic that is derived from a bargain with an extraplanar entity"),
            new RpgClass(13L, "Wizard", 6, 2,
               "A scholarly magic-user capable of manipulating the structures of reality")));


}
