/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nc.opt.tempsattente;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static nc.opt.tempsattente.Agences.BASE_URL;
import static nc.opt.tempsattente.Agences.getProxy;
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
            assertEquals(17, Agences.getAgences(Agences.Commune.NOUMEA).size(), "Longueur de listes différentes");

        } catch (IOException ex) {
            Logger.getLogger(AgencesTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of getAgences method, of class Agences.
     */
    @Test
    public void testGetAgencesNullCommune() {
        System.out.println("\ngetAgences(Commune)_null_TEST");
        Agences.Commune commune = null;
        try {
            assertTrue(Agences.getAgences(commune).isEmpty(), "Liste non vide");

        } catch (IOException ex) {
            Logger.getLogger(AgencesTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Test of getAll method, of class Agences.
     */
    @Test
    public void testGetAgences_all() throws IOException {
        System.out.println("\ngetAgence()_TEST");

        URL url = new URL(BASE_URL);
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode jsonNode = mapper.readValue(url, JsonNode.class);
        int total = jsonNode.get("hits").get("total").asInt();

        try {
            System.out.println("\n" + Agences.getAgences().size());
            assertEquals(total, Agences.getAgences().size(), "Longueur de liste différentes.");

        } catch (IOException ex) {
            Logger.getLogger(AgencesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGetAgencesByDistance() throws Exception {
        assertEquals(5, Agences.getAgencesByDistance(166.4260482788086, -22.25097078275085, 3000).size());
    }

    /**
     * Test of getCommunesNames method, of class Agences.
     */
    @Test
    public void testGetCommunesNames() {
        System.out.println("\ngetCommunesNames_TEST");
        assertEquals(34, Agences.getCommunesNames().size(), "Longueur de liste différentes.");
    }

    /**
     * Test of getCommune(null) method, of class Agences.
     */
    @Test
    public void testGetCommune_null() {
        System.out.println("\ngetCommune_null_TEST");
        String commune_name = null;
        assertNull(Agences.getCommune(commune_name), "Une correspondance a été trouvée.");
    }

    /**
     * Test of getCommune("") method, of class Agences.
     */
    @Test
    public void testGetCommune_empty() {
        System.out.println("\ngetCommune_empty_TEST");
        String commune_name = "";
        assertNull(Agences.getCommune(commune_name), "Une correspondance a été trouvée.");
    }

    /**
     * Test of getCommune("Nouméa") method, of class Agences.
     */
    @Test
    public void testGetCommuneGoodUpperAccents() {
        System.out.println("\ngetCommune_good_upper_accents_TEST");
        String commune_name = "Nouméa";
        assertNotNull(Agences.getCommune(commune_name), "Une correspondance a été trouvée.");
    }

    /**
     * Test of getCommune("noumea") method, of class Agences.
     */
    @Test
    public void testGetCommuneGood() {
        System.out.println("\ngetCommune_good_TEST");
        String commune_name = "noumea";
        assertEquals(Agences.Commune.NOUMEA, Agences.getCommune(commune_name), "Une correspondance a été trouvée.");
    }

    /**
     * Test of getCommune("test") method, of class Agences.
     */
    @Test
    public void testGetCommuneBad() {
        System.out.println("\ngetCommune_bad_TEST");
        String commune_name = "test";
        assertNull(Agences.getCommune(commune_name), "Une correspondance a été trouvée.");
    }

    /**
     * Test of convertWaintingTimeToMillis method, of class Agences.
     */
    @Test
    public void testConvertWaitingTimeToMillis() {
        System.out.println("\nconvertWaitingTimeToMillis_TEST");

        String duree_string = "00:04:10";
        long duree = Agences.convertToMillis(duree_string);

        LocalDateTime start = LocalDateTime.parse("2020-03-07 23:56:00",
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime end = LocalDateTime.parse("2020-03-08 00:00:10",
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println("duree entre : " + start + " et " + end + " : " + duree + " ms.");

        assertEquals(start.plus(duree, ChronoUnit.MILLIS), end, "La duree est incorrecte");
    }
    
    /**
     * Demo test method, of class Agences.
     */
    @Test
    public void testDemo() {
        System.out.println("\ndemo_TEST");
        try {

            System.out.println("<" + Agences.getAgences().size() + "> agences trouvées");
            System.out.println("<" + Agences.getAgences(Agences.Commune.NOUMEA).size() + "> agences trouvées pour <"
                    + Agences.Commune.NOUMEA + ">");
            System.out.println("Correspondance trouvée pour l'ID 4177 : " + Agence.getAgence(4177).toString());

            assertEquals(17, Agences.getAgences(Agences.Commune.NOUMEA).size(), "La liste est vide.");
            assertEquals(64, Agences.getAgences().size(), "La liste est vide.");
            assertEquals("Agence philatélique",
                Agence.getAgence(4177).getDesignation(),
                "Les agences ne correspondent pas");

        } catch (IOException e) {
            Logger.getLogger(AgencesTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Test
    public void testHttpProxy(){
        System.setProperty("http.proxyHost","localhost");
        System.setProperty("http.proxyPort","9000");
        Proxy proxy = getProxy();
        assertNotNull(proxy);
    }

    @Test
    public void testHttpsProxy(){
        System.setProperty("https.proxyHost","localhost");
        System.setProperty("https.proxyPort","8443");
        Proxy proxy = getProxy();
        assertNotNull(proxy);
    }

    @Test
    public void testNoProxy(){
        System.getProperties().remove("http.proxyHost");
        System.getProperties().remove("https.proxyHost");
        System.getProperties().remove("https.proxyPort");
        System.getProperties().remove("http.proxyPort");
        Proxy proxy = getProxy();
        assertNull(proxy);
    }

}
