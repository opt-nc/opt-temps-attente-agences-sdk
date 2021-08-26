/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nc.opt.tempsattente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

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

        Agence instance = new Agence(123456, "designationTEST", 0, 0, 0, 0, 0, new LonLat(1d, 2d), "", "", "", "", "", "", "", "", "");

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

        Agence instance = new Agence(123456, "designationTEST", 0, 0, 0, 0, 0, new LonLat(1d, 2d), "", "", "", "", "", "", "", "", "");

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

        Agence instance = new Agence(123456, "designationTEST", Agences.convertToMillis("00:00:52"), 0, 0, 0, 0, new LonLat(1d, 2d), "", "", "", "", "", "", "", "", "");

        long expResult = Agences.convertToMillis("00:00:52");
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

        long expResult = Agences.convertToMillis("00:00:52");
        instance.setRealMaxWaitingTimeMs(Agences.convertToMillis("00:00:52"));
        long result = instance.getRealMaxWaitingTimeMs();

        assertEquals(expResult, result, "realMaxWaStringingTime non modifié");
    }

    /**
     * Test of getCoordonneeX() method, of class Agence.
     */
    @Test
    public void testGetCoordonneeX() {
        System.out.println("\ngetCoordonneeX_TEST");

        Agence instance = new Agence(123456, "designationTEST", 0, 422331.96350000054, 0, 0, 0, new LonLat(1d, 2d), "", "", "", "", "", "", "", "", "");

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

        Agence instance = new Agence(123456, "designationTEST", 0, 0, 242663.05560000055, 0, 0, new LonLat(1d, 2d), "", "", "", "", "", "", "", "", "");

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

        Agence instance = new Agence(123456, "designationTEST", 0, 0, 0, 422655, 0, new LonLat(1d, 2d), "", "", "", "", "", "", "", "", "");

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

        Agence instance = new Agence(123456, "designationTEST", 0, 0, 0, 0, 242977, new LonLat(1d, 2d), "", "", "", "", "", "", "", "", "");

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
            List<Agence> agences = Agences.getAgences(Agences.Commune.NOUMEA);
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
     * Test of getCommune(testCommune) method, of class Agence.
     */
    @Test
    public void testGetSetCommune() {
        String commune = "testCommune";

        Agence agence = new Agence();
        agence.setCommune(commune);

        assertEquals(commune, agence.getCommune(), "Commune non modifiée.");
    }

    /**
     * Test of getType(testType) method, of class Agence.
     */
    @Test
    public void testGetSetType() {
        String type = "testType";

        Agence agence = new Agence();
        agence.setType(type);

        assertEquals(type, agence.getType(), "Type non modifiée.");
    }

    /**
     * Test of getCodeESirius(testCodeESirius) method, of class Agence.
     */
    @Test
    public void testGetSetCodeESirius() {
        String codeESirius = "testCodeESirius";

        Agence agence = new Agence();
        agence.setCodeESirius(codeESirius);

        assertEquals(codeESirius, agence.getCodeESirius(), "CodeESirius non modifiée.");
    }

    /**
     * Test of getCodePostale(testCodePostale) method, of class Agence.
     */
    @Test
    public void testGetSetCodePostal() {
        String codePostal = "testCodePostal";

        Agence agence = new Agence();
        agence.setCodePostal(codePostal);

        assertEquals(codePostal, agence.getCodePostal(), "CodePostal non modifiée.");
    }

    /**
     * Test of getlieuDitOuTribu(testLieuDitOuTribu) method, of class Agence.
     */
    @Test
    public void testGetSetLieuDitOuTribu() {
        String lieuDitOuTribu = "testCodeESirius";

        Agence agence = new Agence();
        agence.setLieuDitOuTribu(lieuDitOuTribu);

        assertEquals(lieuDitOuTribu, agence.getLieuDitOuTribu(), "LieuDitOuTribu non modifiée.");
    }

    /**
     * Test of getLocalite(testLocalite) method, of class Agence.
     */
    @Test
    public void testGetSetLocalite() {
        String localite = "testLocalite";

        Agence agence = new Agence();
        agence.setLocalite(localite);

        assertEquals(localite, agence.getLocalite(), "Localite non modifiée.");
    }

    /**
     * Test of getIdRefloc(testIdRefloc) method, of class Agence.
     */
    @Test
    public void testGetSetIdRefloc() {
        String idRefloc = "testIdRefloc";

        Agence agence = new Agence();
        agence.setIdRefloc(idRefloc);

        assertEquals(idRefloc, agence.getIdRefloc(), "IdRefloc non modifiée.");
    }

    /**
     * Test of getCodePostalRefloc(testCodePostalRefloc) method, of class Agence.
     */
    @Test
    public void testGetSetCodePostalRefloc() {
        String codePostalRefloc = "testCodePostalRefloc";

        Agence agence = new Agence();
        agence.setCodePostalRefloc(codePostalRefloc);

        assertEquals(codePostalRefloc, agence.getCodePostalRefloc(), "CodePostalRefloc non modifiée.");
    }

    /**
     * Test of getLocaliteRefloc(testLocaliteRefloc) method, of class Agence.
     */
    @Test
    public void testGetSetLocaliteRefloc() {
        String localiteRefloc = "testCodePostalRefloc";

        Agence agence = new Agence();
        agence.setLocaliteRefloc(localiteRefloc);

        assertEquals(localiteRefloc, agence.getLocaliteRefloc(), "LocaliteRefloc non modifiée.");
    }

    /**
     * Test of toString method, of class Agence.
     */
    @Test
    public void testToString() {
        System.out.println("\ntoString_TEST");

        int idAgence = 123456;
        String designation = "designationTEST";
        long realMaxWaitingTimeMs = Agences.convertToMillis("00:00:52");
        double coordonneeX = 422331.96350000054;
        double coordonneeY = 242663.05560000055;
        long coordonneeXPrecise = 422655;
        long coordonneeYPrecise = 242977;
        String commune = "communeTEST";
        String type = "typeTEST";
        String codeESirius = "codeESiriusTEST";
        String codePostal = "codePostalTEST";
        String lieuDitOuTribu = "lieuDitOuTribuTEST";
        String localite = "localiteTEST";
        String idRefloc = "idReflocTEST";
        String codePostalRefloc = "codePostalReflocTEST";
        String localiteRefloc = "localiteReflocTEST";
        Agence instance = new Agence(
                123456,
                "designationTEST",
                Agences.convertToMillis("00:00:52"),
                422331.96350000054,
                242663.05560000055,
                422655,
                242977,
                new LonLat(1d, 2d),
                commune, type, codeESirius, codePostal, lieuDitOuTribu,
                localite, idRefloc, codePostalRefloc, localiteRefloc);

        String expResult = "Agence " + idAgence
                + " <designation: " + designation
                + ", realMaxWaitingTimeMs: " + realMaxWaitingTimeMs
                + ", coordonneeX: " + coordonneeX
                + ", coordonneeY: " + coordonneeY
                + ", coordonneeXPrecise: " + coordonneeXPrecise
                + ", coordonneeYPrecise: " + coordonneeYPrecise
                + ", position: {lon: 1.000000, lat: 2.000000}"
                + ", commune: " + commune
                + ", type: " + type
                + ", codeESirius: " + codeESirius
                + ", codePostal: " + codePostal
                + ", lieuDitOuTribu: " + lieuDitOuTribu
                + ", localite: " + localite
                + ", idRefloc: " + idRefloc
                + ", codePostalRefloc: " + codePostalRefloc
                + ", localiteRefloc: " + localiteRefloc
                + ">";
        String result = instance.toString();

        assertEquals(expResult, result, "Les chaînes sont différentes.");
    }

}
