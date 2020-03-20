/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.opt.tempsattente.sdk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class of class Agence.
 *
 * @author meilie
 */
public class AgenceTest {

    /**
     * Constructor.
     */
    public AgenceTest() {
    }

    @Test
    public void testGetIdAgence() {
        System.out.println("\ngetIdAgence_TEST");

        Agence instance = new Agence(123456, "designationTEST");

        int expResult = 123456;
        int result = instance.getIdAgence();

        assertEquals(expResult, result, "id non trouvé.");
    }

    @Test
    public void testSetIdAgence() {
        System.out.println("\nsetIdAgence_TEST");

        Agence instance = new Agence();

        int expResult = 123456;
        instance.setIdAgence(123456);
        int result = instance.getIdAgence();

        assertEquals(expResult, result, "id non modifié");
    }

    /**
     * Test of getDesignation method, of class Agence.
     */
    @Test
    public void testGetDesignation() {
        System.out.println("\ngetDesignation_TEST");

        Agence instance = new Agence(123456, "designationTEST");

        String expResult = "designationTEST";
        String result = instance.getDesignation();

        assertEquals(expResult, result, "designation non trouvée.");
    }

    /**
     * Test of setDesignation method, of class Agence.
     */
    @Test
    public void testSetDesignation() {
        System.out.println("\nsetDesignation_TEST");

        Agence instance = new Agence();

        String expResult = "designationTEST";
        instance.setDesignation("designationTEST");
        String result = instance.getDesignation();

        assertEquals(expResult, result, "designation non modifiée");
    }

    /**
     * Test of getRealMaxWaitingTime method, of class Agence.
     */
    @Test
    public void testGetRealMaxWaitingTime() {
        System.out.println("\ngetRealMaxWaitingTime_TEST");

        Agence instance = new Agence(123456, "designationTEST", Agences.ConvertToMillis("00:00:52"));

        long expResult = Agences.ConvertToMillis("00:00:52");
        long result = instance.getRealMaxWaitingTimeMs();
        assertEquals(expResult, result, "realMaxWaStringingTime non trouvé");
    }

    /**
     * Test of setRealMaxWaitingTime method, of class Agence.
     */
    @Test
    public void testSetRealMaxWaitingTime() {
        System.out.println("\nsetRealMaxWaitingTime_TEST");

        Agence instance = new Agence();

        long expResult = Agences.ConvertToMillis("00:00:52");
        instance.setRealMaxWaitingTimeMs(Agences.ConvertToMillis("00:00:52"));
        long result = instance.getRealMaxWaitingTimeMs();

        assertEquals(expResult, result, "realMaxWaStringingTime non modifié");
    }

    @Test
    public void testGetAgence() {
        System.out.println("\ngetAgence_TEST");
        try {
            ArrayList<Agence> agences = Agences.getAgences(Agences.Commune.NOUMEA);
            Agence expResult = new Agence();
            int idAgence = 4177;
            for (Agence agence : agences) {
                if (agence.getIdAgence() == idAgence) {
                    expResult = agence;
                }
            }
            Agence result = Agence.getAgence(idAgence);
            assertEquals(expResult.toString(), result.toString(), "Aucune agence trouvée.");
        } catch (IOException e) {
            Logger.getLogger(AgencesTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    @Test
    public void testGetAgenceBadID() {
        System.out.println("\ngetAgence_badID_TEST");
        try {
            Agence result = Agence.getAgence(456);
            assertNull(result, "Aucune agence trouvée.");
        } catch (IOException e) {
            Logger.getLogger(AgencesTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Test of toString method, of class Agence.
     */
    @Test
    public void testToString() {
        System.out.println("\ntoString_TEST");

        int idAgence = 123456;
        String designation = "designationTEST";
        long realMaxWaitingTimeMs = Agences.ConvertToMillis("00:00:52");
        Agence instance = new Agence(123456, "designationTEST", Agences.ConvertToMillis("00:00:52"));

        String expResult = "Agence " + idAgence + " <designation: " + designation + ", realMaxWaitingTimeMs: " + realMaxWaitingTimeMs + ">";
        String result = instance.toString();

        assertEquals(expResult, result, "Les chaînes sont différentes.");
    }

}
