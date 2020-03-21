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

    /**
     * Test of getIdAgence() method, of class Agence.
     */
    @Test
    public void testGetIdAgence() {
        System.out.println("\ngetIdAgence_TEST");

        Agence instance = new Agence(123456, "designationTEST", 0, 0, 0, 0, 0);

        int expResult = 123456;
        int result = instance.getIdAgence();

        assertEquals(expResult, result, "id non trouvé.");
    }

    /**
     * Test of setIdAgence() method, of class Agence.
     */
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

        Agence instance = new Agence(123456, "designationTEST", 0, 0, 0, 0, 0);

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

        Agence instance = new Agence(123456, "designationTEST", Agences.ConvertToMillis("00:00:52"), 0, 0, 0, 0);

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

    /**
     * Test of getCoordonneeX() method, of class Agence.
     */
    @Test
    public void testGetCoordonneeX() {
        System.out.println("\ngetCoordonneeX_TEST");

        Agence instance = new Agence(123456, "designationTEST", 0, 422331.96350000054, 0, 0, 0);

        double expResult = 422331.96350000054;
        double result = instance.getCoordonneeX();
        assertEquals(expResult, result, "CoordonneeX non trouvée");
    }

    /**
     * Test of setCoordonneeX() method, of class Agence.
     */
    @Test
    public void testSetCoordonneeX() {
        System.out.println("\nsetCoordonneeX_TEST");

        Agence instance = new Agence();

        double expResult = 422331.96350000054;
        instance.setCoordonneeX(422331.96350000054);
        double result = instance.getCoordonneeX();

        assertEquals(expResult, result, "CoordonneeX non modifiée");
    }

    /**
     * Test of getCoordonneeY() method, of class Agence.
     */
    @Test
    public void testGetCoordonneeY() {
        System.out.println("\ngetCoordonneeY_TEST");

        Agence instance = new Agence(123456, "designationTEST", 0, 0, 242663.05560000055, 0, 0);

        double expResult = 242663.05560000055;
        double result = instance.getCoordonneeY();
        assertEquals(expResult, result, "CoordonneeY non trouvée");
    }

    /**
     * Test of setCoordonneeY() method, of class Agence.
     */
    @Test
    public void testSetCoordonneeY() {
        System.out.println("\nsetCoordonneeY_TEST");

        Agence instance = new Agence();

        double expResult = 242663.05560000055;
        instance.setCoordonneeY(242663.05560000055);
        double result = instance.getCoordonneeY();

        assertEquals(expResult, result, "CoordonneeY non modifiée");
    }

    /**
     * Test of getCoordonneeXPrecise() method, of class Agence.
     */
    @Test
    public void testGetCoordonneeXPrecise() {
        System.out.println("\ngetCoordonneeXPrecise_TEST");

        Agence instance = new Agence(123456, "designationTEST", 0, 0, 0, 422655, 0);

        long expResult = 422655;
        long result = instance.getCoordonneeXPrecise();
        assertEquals(expResult, result, "CoordonneeXPrecise non trouvée");
    }

    /**
     * Test of setCoordonneeXPrecise() method, of class Agence.
     */
    @Test
    public void testSetCoordonneeXPrecise() {
        System.out.println("\nsetCoordonneeXPrecise_TEST");

        Agence instance = new Agence();

        long expResult = 422655;
        instance.setCoordonneeXPrecise(422655);
        long result = instance.getCoordonneeXPrecise();

        assertEquals(expResult, result, "CoordonneeXPrecise non modifiée");
    }

    /**
     * Test of getCoordonneeYPrecise() method, of class Agence.
     */
    @Test
    public void testGetCoordonneeYPrecise() {
        System.out.println("\ngetCoordonneeYPrecise_TEST");

        Agence instance = new Agence(123456, "designationTEST", 0, 0, 0, 0, 242977);

        long expResult = 242977;
        long result = instance.getCoordonneeYPrecise();
        assertEquals(expResult, result, "CoordonneeYPrecise non trouvée");
    }

    /**
     * Test of setCoordonneeYPrecise() method, of class Agence.
     */
    @Test
    public void testSetCoordonneeYPrecise() {
        System.out.println("\nsetCoordonneeYPrecise_TEST");

        Agence instance = new Agence();

        long expResult = 242977;
        instance.setCoordonneeYPrecise(242977);
        long result = instance.getCoordonneeYPrecise();

        assertEquals(expResult, result, "CoordonneeYPrecise non modifiée");
    }

    /**
     * Test of getAgence(4177) method, of class Agence.
     */
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

    /**
     * Test of getAgence(456) method, of class Agence.
     */
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
        double coordonneeX = 422331.96350000054;
        double coordonneeY = 242663.05560000055;
        long coordonneeXPrecise = 422655;
        long coordonneeYPrecise = 242977;
        Agence instance = new Agence(123456, "designationTEST", Agences.ConvertToMillis("00:00:52"), 422331.96350000054, 242663.05560000055, 422655, 242977);

        String expResult = "Agence " + idAgence
                + " <designation: " + designation
                + ", realMaxWaitingTimeMs: " + realMaxWaitingTimeMs
                + ", coordonneeX: " + coordonneeX
                + ", coordonneeY: " + coordonneeY
                + ", coordonneeXPrecise: " + coordonneeXPrecise
                + ", coordonneeYPrecise: " + coordonneeYPrecise
                + ">";
        String result = instance.toString();

        assertEquals(expResult, result, "Les chaînes sont différentes.");
    }

}
