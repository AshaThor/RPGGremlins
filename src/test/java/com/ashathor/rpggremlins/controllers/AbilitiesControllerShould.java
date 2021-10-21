package com.ashathor.rpggremlins.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
class AbilitiesControllerShould {

    private static final Logger log = Logger.getLogger(AbilitiesControllerShould.class.getName());

    @Autowired
    private AbilityController abilityControlley;

    @Test
    public void bePresent() {
        log.info("Test 1: ");
        assertNotNull("test ",abilityControlley);
    }

    @Test
    public void returnAblilitiesList() {
        assertEquals("Root returned successfully","abilities",abilityControlley.listAll());
        log.info("Return Abilities List Link Success");
    }


}