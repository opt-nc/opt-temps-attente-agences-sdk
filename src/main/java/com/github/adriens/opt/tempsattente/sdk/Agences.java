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
    
    public Commune commune;
    
    public enum Commune {
        BOULOUPARIS,
        MOINDOU,
        NOUMEA,
        HOUAILOU,
        KONE,
        KAALA_GOMEN,
        POUEBO,
        THIO,
        TADINE,
        MONT_DORE,
        KOUAOUA,
        POYA,
        BELEP,
        ILE_DES_PINS,
        DUMBEA,
        BOURAIL,
        CANALA,
        FAYAOUE,
        POUM,
        TOUHO,
        POUEMBOUT,
        KOUMAC,
        PAITA,
        SARRAMEA,
        LIFOU,
        OUEGOA,
        YATE,
        LA_FOA,
        HIENGHENE,
        MARE,
        POINDIMIE,
        PONERIHOUEN,
        VOH;

        private String url;

        public String getUrl() {
            return this.url;
        }

        public void setUrl(Commune commune) {
            switch (commune) {
                case BOULOUPARIS:
                    this.url = "&q=localiteRefloc:(BOULOUPARIS)";
                    break;
                case MOINDOU:
                    this.url = "&q=localiteRefloc:(MOINDOU)";
                    break;
                case NOUMEA:
                    this.url = "&q=localiteRefloc:(NOUMEA)";
                    break;
                case HOUAILOU:
                    this.url = "&q=localiteRefloc:(HOUAILOU)";
                    break;
                case KONE:
                    this.url = "&q=localiteRefloc:(KONE)";
                    break;
                case KAALA_GOMEN:
                    this.url = "&q=localiteRefloc:(KAALA-GOMEN)";
                    break;
                case POUEBO:
                    this.url = "&q=localiteRefloc:(POUEBO)";
                    break;
                case THIO:
                    this.url = "&q=localiteRefloc:(THIO)";
                    break;
                case TADINE:
                    this.url = "&q=localiteRefloc:(TADINE)";
                    break;
                case MONT_DORE:
                    this.url = "&q=localiteRefloc:(MONT-DORE)";
                    break;
                case KOUAOUA:
                    this.url = "&q=localiteRefloc:(KOUAOUA)";
                    break;
                case POYA:
                    this.url = "&q=localiteRefloc:(POYA)";
                    break;
                case BELEP:
                    this.url = "&q=localiteRefloc:(BELEP)";
                    break;
                case ILE_DES_PINS:
                    this.url = "&q=localiteRefloc:(ILE%20AND%20DES%20AND%20PINS)";
                    break;
                case DUMBEA:
                    this.url = "&q=localiteRefloc:(DUMBEA)";
                    break;
                case BOURAIL:
                    this.url = "&q=localiteRefloc:(BOURAIL)";
                    break;
                case CANALA:
                    this.url = "&q=localiteRefloc:(CANALA)";
                    break;
                case FAYAOUE:
                    this.url = "&q=localiteRefloc:(FAYAOUE)";
                    break;
                case POUM:
                    this.url = "&q=localiteRefloc:(POUM)";
                    break;
                case TOUHO:
                    this.url = "&q=localiteRefloc:(TOUHO)";
                    break;
                case POUEMBOUT:
                    this.url = "&q=localiteRefloc:(POUEMBOUT)";
                    break;
                case KOUMAC:
                    this.url = "&q=localiteRefloc:(KOUMAC)";
                    break;
                case PAITA:
                    this.url = "&q=localiteRefloc:(PAITA)";
                    break;
                case SARRAMEA:
                    this.url = "&q=localiteRefloc:(SARRAMEA)";
                    break;
                case LIFOU:
                    this.url = "&q=localiteRefloc:(LIFOU)%20OR%20localiteRefloc:(WE)";
                    break;
                case OUEGOA:
                    this.url = "&q=localiteRefloc:(OUEGOA)";
                    break;
                case YATE:
                    this.url = "&q=localiteRefloc:(YATE)";
                    break;
                case LA_FOA:
                    this.url = "&q=localiteRefloc:(LA%20AND%20FOA)";
                    break;
                case HIENGHENE:
                    this.url = "&q=localiteRefloc:(HIENGHENE)";
                    break;
                case MARE:
                    this.url = "&q=localiteRefloc:(MARE)";
                    break;
                case POINDIMIE:
                    this.url = "&q=localiteRefloc:(POINDIMIE)";
                    break;
                case PONERIHOUEN:
                    this.url = "&q=localiteRefloc:(PONERIHOUEN)";
                    break;
                case VOH:
                    this.url = "&q=localiteRefloc:(VOH)";
                    break;
            }
        }

    }
    
    
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

        logger.info("------------------------------------------------------------");
     
        ArrayList<Agence> listeAgences = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        logger.info("Recherche de l'URL : ");
        commune.setUrl(commune);
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
