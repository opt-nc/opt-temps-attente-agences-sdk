/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tempsattente.sdk;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
     
    @Test
    public void testGetAgences() {
        System.out.println("\ngetAgences(Commune)_TEST");
        
        try {
            
            for (Commune commune : Commune.values()) {
                System.out.println("expResult : ");
                ArrayList<Agence> expResult = new ArrayList<>();
                expResult.addAll(Agences.getAgences(commune));
                
                System.out.println("result : ");
                Agences agences = new Agences();
                ArrayList<Agence> listResult = new ArrayList<>();
                listResult.addAll(Agences.getAgences(commune));
                agences.setAgences(listResult);
                ArrayList<Agence> result = agences.agences();

                assertEquals(expResult.size(), result.size(), "Longueur de listes différentes");
                assertEquals(expResult.get(0).getDesignation(), result.get(0).getDesignation(), "Contenu de liste différents");
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(AgencesTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of getAll method, of class Agences.
     
    @Test
    public void testGetAgences_all() {
        System.out.println("\ngetAgence()_TEST");

        try {

            System.out.println("expResult : ");
            ArrayList<Agence> expResult = Agences.getAgences(Commune.ALL);

            System.out.println("result : ");
            Agences agences = new Agences(Agences.getAgences());
            ArrayList<Agence> result = agences.agences();

            assertEquals(expResult.size(), result.size(), "Longueur de liste différentes.");
            assertEquals(expResult.get(0).getDesignation(), result.get(0).getDesignation(), "Contenu de liste différents.");

        } catch (IOException ex) {
            Logger.getLogger(AgencesTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of setAgences method, of class Agences.
     
    @Test
    public void testSetAgences() {
        System.out.println("\nsetAgences_TEST");

        try {

            System.out.println("expResult : ");
            ArrayList<Agence> expResult = Agences.getAgences(Commune.NOUMEA);

            System.out.println("result : ");
            Agences agences = new Agences();
            agences.setAgences(Agences.getAgences(Commune.NOUMEA));
            ArrayList<Agence> result = agences.agences();

            assertEquals(expResult.size(), result.size(), "Longueur de liste différente.");
            assertEquals(expResult.get(0).getDesignation(), result.get(0).getDesignation(), "Contenu de liste différent.");

        } catch (IOException ex) {
            Logger.getLogger(AgencesTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of getCommune method, of class Agences.
     */ 
    @Test
    public void testGetCommune() {
        System.out.println("\ngetCommune_TEST");

        String expResult = "NOUMEA";
        String result = Commune.NOUMEA.name();

        assertEquals(expResult, result, "Nom de commune différents.");
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
     
    @Test
    public void testDemo() {
        System.out.println("\ndemo_TEST");

        try {
            Agences agences_noumea = new Agences(Agences.getAgences(Commune.NOUMEA));
            System.out.println("<" + agences_noumea.agences().size() + "> agences trouvées pour <" + Commune.NOUMEA.name() + ">");
            Agences agences_all = new Agences(Agences.getAgences());
            System.out.println("<" + agences_all.agences().size() + "> agences trouvées");
            assertFalse(agences_noumea.agences().isEmpty(), "La liste est vide.");
            assertFalse(agences_all.agences().isEmpty(), "La liste est vide.");

        } catch (IOException e) {
            Logger.getLogger(AgencesTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }
*/
}
