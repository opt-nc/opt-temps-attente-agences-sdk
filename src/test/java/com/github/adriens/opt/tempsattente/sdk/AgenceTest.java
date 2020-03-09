/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.opt.tempsattente.sdk;

import com.github.adriens.opt.tempsattente.sdk.Agence;
import com.github.adriens.opt.tempsattente.sdk.Agences;
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
     * Test of getDesignation method, of class Agence.
     */
    @Test
    public void testGetDesignation() {
        System.out.println("\ngetDesignation_TEST");

        Agence instance = new Agence("designationTEST");

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

        Agence instance = new Agence("designationTEST", Agences.ConvertToMillis("00:00:52"));

        long expResult = Agences.ConvertToMillis("00:00:52");
        long result = instance.getRealMaxWaitingTime();
        assertEquals(expResult, result, "realMaxWaintingTime non trouvé");
    }

    /**
     * Test of setRealMaxWaitingTime method, of class Agence.
     */
    @Test
    public void testSetRealMaxWaitingTime() {
        System.out.println("\nsetRealMaxWaitingTime_TEST");

        Agence instance = new Agence();

        long expResult = Agences.ConvertToMillis("00:00:52");
        instance.setRealMaxWaitingTime(Agences.ConvertToMillis("00:00:52"));
        long result = instance.getRealMaxWaitingTime();

        assertEquals(expResult, result, "realMaxWaintingTime non modifié");
    }

    /**
     * Test of toString method, of class Agence.
     */
    @Test
    public void testToString() {
        System.out.println("\ntoString_TEST");

        String designation = "designationTEST";
        long realMaxWaitingTime = Agences.ConvertToMillis("00:00:52");
        Agence instance = new Agence("designationTEST", Agences.ConvertToMillis("00:00:52"));

        String expResult = "designation: <" + designation + ">, realMaxWaitingTime: <" + realMaxWaitingTime + ">";
        String result = instance.toString();

        assertEquals(expResult, result, "Les chaînes sont différentes.");
    }

}
