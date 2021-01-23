package com.ashathor.rpggremlins.controllers;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.logging.Logger;
import static org.junit.Assert.*;


@SpringBootTest
public class RPGClassControllerShould {

    private static final Logger log = Logger.getLogger(RPGClassControllerShould.class.getName());

    @Autowired
    private RpgClassController rpgClassController;


    @Test
    public void bePresent() {
        log.info("Test 1: ");
        assertNotNull("test ",rpgClassController);
    }

    @Test
    public void returnClassesListLink() {
        ModelMap modelMap = new ModelMap();
        assertEquals("Root returned successfully","rpgclass/rpgclasses",rpgClassController.listClasses(modelMap));
        log.info("Return Classes List Link Success");
    }

    @Test
    public void returnIndividualClassLink() {
        ModelMap modelMap = new ModelMap();
        assertEquals("Root returned successfully","rpgclass/rpgclass",rpgClassController.getById(1, modelMap));
        log.info("Return Individual Class Link Success");
    }

    @Test
    public void returnAdminLink() {
        ModelMap modelMap = new ModelMap();
        assertEquals("Root returned successfully","rpgclass/admin",rpgClassController.rpgClassAdmin(modelMap));
        log.info("Return Class Admin Link Success");
    }

   /*@Test
    public void returnNewLink() {
        assertEquals("Root returned successfully","rpgclass/admin",rpgClassController.rpgClassForm());
        log.info("Return Class Admin Link Success");
    }*/
}
