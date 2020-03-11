/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.opt.tempsattente.sdk;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class of class Agences.
 *
 * @author meilie
 */
public class AgencesTest {

    /**
     * Constructor.
     */
    public AgencesTest() {
    }

    /**
     * Test of getAgences method, of class Agences.
     */
    @Test
    public void testGetAgences() {
        System.out.println("\ngetAgences(Commune)_TEST");

        try {
            assertEquals(17, Agences.getAgences(Commune.NOUMEA).size(), "Longueur de listes différentes");

        } catch (IOException ex) {
            Logger.getLogger(AgencesTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of getAll method, of class Agences.
     */
    @Test
    public void testGetAgences_all() {
        System.out.println("\ngetAgence()_TEST");

        try {
            assertEquals(65, Agences.getAgences().size(), "Longueur de liste différentes.");

        } catch (IOException ex) {
            Logger.getLogger(AgencesTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of convertWaintingTimeToMillis method, of class Agences.
     */
    @Test
    public void testConvertWaitingTimeToMillis() {
        System.out.println("\nconvertWaitingTimeToMillis_TEST");

        String duree_string = "00:04:10";
        long duree = Agences.ConvertToMillis(duree_string);

        LocalDateTime start = LocalDateTime.parse("2020-03-07 23:56:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime end = LocalDateTime.parse("2020-03-08 00:00:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println("duree entre : " + start + " et " + end + " : " + duree + " ms.");

        assertEquals(start.plus(duree, ChronoUnit.MILLIS), end, "La duree est incorrecte");
    }

    /**
     * Demo test method, of class Agences.
     */
    @Test
    public void testDemo() {
        System.out.println("\ndemo_TEST");
        Agences agences = new Agences();
        try {

            System.out.println("<" + Agences.getAgences().size() + "> agences trouvées");
            System.out.println("<" + Agences.getAgences(Commune.NOUMEA).size() + "> agences trouvées pour <" + Commune.NOUMEA + ">");

            assertEquals(17, Agences.getAgences(Commune.NOUMEA).size(), "La liste est vide.");
            assertEquals(65, Agences.getAgences().size(), "La liste est vide.");

        } catch (IOException e) {
            Logger.getLogger(AgencesTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
