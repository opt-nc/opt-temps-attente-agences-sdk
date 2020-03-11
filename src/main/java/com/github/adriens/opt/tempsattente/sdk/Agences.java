/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.opt.tempsattente.sdk;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author meilie
 * <br>
 * <p>
 * A <code><b>Agences</b></code> object represents a list of agencies, a list of
 * <code><b>Agence</b></code> objects.
 * </p>
 *
 */
public class Agences {

    final static Logger logger = LoggerFactory.getLogger(Agences.class);

    /**
     * The base of the url where the data is retrieved.
     */
    public static final String BASE_URL = "https://open-data.opt.nc/agences/_search?size=1000";

    /**
     * Return the list of all the agencies.
     *
     * @return the list of all the agencies.
     * @throws IOException
     */
    public static ArrayList<Agence> getAgences() throws IOException {
        ArrayList<Agence> listeAgences = new ArrayList<>();

        for (Commune value : Commune.values()) {
            ArrayList<Agence> listeAgences_commune = Agences.getAgences(value);
            listeAgences.addAll(listeAgences_commune);
        }

        return listeAgences;
    }

    /**
     * Return the list of agencies for the Commune in parameter.
     *
     * @param commune the location zone of agencies.
     * @return the list of agencies for the Commune in parameter.
     * @throws IOException
     */
    public static ArrayList<Agence> getAgences(Commune commune) throws IOException {

        logger.info("------------------------------------------------------------");;
        ArrayList<Agence> listeAgences = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        logger.info("Recherche de l'URL : ");
        URL url = new URL("" + BASE_URL + commune.getUrl());

        logger.info("Recupération des données des agences : ");
        JsonNode jsonNode = mapper.readValue(url, JsonNode.class);
        int total = jsonNode.get("hits").get("total").asInt();

        logger.info("Recherche des agences de " + commune.name() + " : " + total + " résultats.");

        for (int i = 0; i < total; i++) {

            try {
                String designation = jsonNode.get("hits").get("hits").get(i).get("_source").get("designation").asText();
                long realMaxWaitingTime = ConvertToMillis(jsonNode.get("hits").get("hits").get(i).get("_source").get("borneEsirius").get("realMaxWaitingTime").asText());

                Agence agence = new Agence(designation, realMaxWaitingTime);
                listeAgences.add(agence);

                logger.info("Agence : " + agence.toString());

            } catch (Exception e) {

                String designation = jsonNode.get("hits").get("hits").get(i).get("_source").get("designation").asText();

                logger.warn("Le temps d'attente maximum de l'agence <" + designation + "> est introuvable...");

                Agence agence = new Agence(designation);
                listeAgences.add(agence);

                logger.info("Agence : " + agence.toString());

            }
        }
        logger.info("------------------------------------------------------------");
        return listeAgences;
    }

    /**
     * Convert duration as "HH:mm:ss" to milliseconds.
     *
     * @param duree A String duration.
     * @return the converted duration in milliseconds
     */
    public static long ConvertToMillis(String duree) {
        LocalTime duree_localTime = LocalTime.parse(duree, DateTimeFormatter.ISO_LOCAL_TIME);
        long millis = ChronoUnit.MILLIS.between(LocalTime.MIN, duree_localTime);
        return millis;
    }

}
