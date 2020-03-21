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
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
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
     * Locations enumeration.
     */
    public static enum Commune {
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

    }

    /**
     * Return the query url, as text, for the Commune.
     *
     * @param commune a location.
     * @return the url as text.
     */
    public static String getUrl(Commune commune) {
        String url = null;
        switch (commune) {
            case BOULOUPARIS:
                url = "&q=localiteRefloc:(BOULOUPARIS)";
                break;
            case MOINDOU:
                url = "&q=localiteRefloc:(MOINDOU)";
                break;
            case NOUMEA:
                url = "&q=localiteRefloc:(NOUMEA)";
                break;
            case HOUAILOU:
                url = "&q=localiteRefloc:(HOUAILOU)";
                break;
            case KONE:
                url = "&q=localiteRefloc:(KONE)";
                break;
            case KAALA_GOMEN:
                url = "&q=localiteRefloc:(KAALA-GOMEN)";
                break;
            case POUEBO:
                url = "&q=localiteRefloc:(POUEBO)";
                break;
            case THIO:
                url = "&q=localiteRefloc:(THIO)";
                break;
            case TADINE:
                url = "&q=localiteRefloc:(TADINE)";
                break;
            case MONT_DORE:
                url = "&q=localiteRefloc:(MONT-DORE)";
                break;
            case KOUAOUA:
                url = "&q=localiteRefloc:(KOUAOUA)";
                break;
            case POYA:
                url = "&q=localiteRefloc:(POYA)";
                break;
            case BELEP:
                url = "&q=localiteRefloc:(BELEP)";
                break;
            case ILE_DES_PINS:
                url = "&q=localiteRefloc:(ILE%20AND%20DES%20AND%20PINS)";
                break;
            case DUMBEA:
                url = "&q=localiteRefloc:(DUMBEA)";
                break;
            case BOURAIL:
                url = "&q=localiteRefloc:(BOURAIL)";
                break;
            case CANALA:
                url = "&q=localiteRefloc:(CANALA)";
                break;
            case FAYAOUE:
                url = "&q=localiteRefloc:(FAYAOUE)";
                break;
            case POUM:
                url = "&q=localiteRefloc:(POUM)";
                break;
            case TOUHO:
                url = "&q=localiteRefloc:(TOUHO)";
                break;
            case POUEMBOUT:
                url = "&q=localiteRefloc:(POUEMBOUT)";
                break;
            case KOUMAC:
                url = "&q=localiteRefloc:(KOUMAC)";
                break;
            case PAITA:
                url = "&q=localiteRefloc:(PAITA)";
                break;
            case SARRAMEA:
                url = "&q=localiteRefloc:(SARRAMEA)";
                break;
            case LIFOU:
                url = "&q=localiteRefloc:(LIFOU)%20OR%20localiteRefloc:(WE)";
                break;
            case OUEGOA:
                url = "&q=localiteRefloc:(OUEGOA)";
                break;
            case YATE:
                url = "&q=localiteRefloc:(YATE)";
                break;
            case LA_FOA:
                url = "&q=localiteRefloc:(LA%20AND%20FOA)";
                break;
            case HIENGHENE:
                url = "&q=localiteRefloc:(HIENGHENE)";
                break;
            case MARE:
                url = "&q=localiteRefloc:(MARE)";
                break;
            case POINDIMIE:
                url = "&q=localiteRefloc:(POINDIMIE)";
                break;
            case PONERIHOUEN:
                url = "&q=localiteRefloc:(PONERIHOUEN)";
                break;
            case VOH:
                url = "&q=localiteRefloc:(VOH)";
                break;
        }
        return url;
    }

    /**
     * Return the list of all the Commune as text.
     *
     * @return the list of Commune as text.
     */
    public static ArrayList<String> getCommunesNames() {
        ArrayList<String> commune_name = new ArrayList<>();

        HashMap<Commune, String> commune_map = new HashMap<>();

        commune_map.put(Commune.BOULOUPARIS, "boulouparis");
        commune_map.put(Commune.MOINDOU, "moindou");
        commune_map.put(Commune.NOUMEA, "noumea");
        commune_map.put(Commune.HOUAILOU, "houailou");
        commune_map.put(Commune.KONE, "kone");
        commune_map.put(Commune.KAALA_GOMEN, "kaala-gomen");
        commune_map.put(Commune.POUEBO, "pouebo");
        commune_map.put(Commune.THIO, "thio");
        commune_map.put(Commune.TADINE, "tadine");
        commune_map.put(Commune.MONT_DORE, "mont-dore");
        commune_map.put(Commune.KOUAOUA, "kouaoua");
        commune_map.put(Commune.POYA, "poya");
        commune_map.put(Commune.BELEP, "belep");
        commune_map.put(Commune.ILE_DES_PINS, "ile des pins");
        commune_map.put(Commune.DUMBEA, "dumbea");
        commune_map.put(Commune.BOURAIL, "bourail");
        commune_map.put(Commune.CANALA, "canala");
        commune_map.put(Commune.FAYAOUE, "fayaoue");
        commune_map.put(Commune.POUM, "poum");
        commune_map.put(Commune.TOUHO, "touho");
        commune_map.put(Commune.POUEMBOUT, "pouembout");
        commune_map.put(Commune.KOUMAC, "koumac");
        commune_map.put(Commune.PAITA, "paita");
        commune_map.put(Commune.SARRAMEA, "sarramea");
        commune_map.put(Commune.LIFOU, "lifou");
        commune_map.put(Commune.OUEGOA, "ouegoa");
        commune_map.put(Commune.YATE, "yate");
        commune_map.put(Commune.LA_FOA, "la foa");
        commune_map.put(Commune.HIENGHENE, "hienghene");
        commune_map.put(Commune.MARE, "mare");
        commune_map.put(Commune.POINDIMIE, "poindimie");
        commune_map.put(Commune.PONERIHOUEN, "ponerihouen");
        commune_map.put(Commune.VOH, "voh");

        for (Commune commune : Commune.values()) {
            logger.info("Ajout de la commune : " + commune_map.get(commune));
            commune_name.add(commune_map.get(commune));
        }
        logger.info("" + commune_name.size() + " communes ajoutées.");
        return commune_name;
    }

    /**
     * Return the Commune matching with the Commune name as text in parameter.
     *
     * @param communeName a Commune name, as text.
     * @return the Commune object with the name in parameter.
     */
    public static Commune getCommune(String communeName) {
        HashMap<String, Commune> commune = new HashMap<>();

        commune.put("boulouparis", Commune.BOULOUPARIS);
        commune.put("moindou", Commune.MOINDOU);
        commune.put("noumea", Commune.NOUMEA);
        commune.put("houailou", Commune.HOUAILOU);
        commune.put("kone", Commune.KONE);
        commune.put("kaala-gomen", Commune.KAALA_GOMEN);
        commune.put("pouebo", Commune.POUEBO);
        commune.put("thio", Commune.THIO);
        commune.put("tadine", Commune.TADINE);
        commune.put("mont-dore", Commune.MONT_DORE);
        commune.put("kouaoua", Commune.KOUAOUA);
        commune.put("poya", Commune.POYA);
        commune.put("belep", Commune.BELEP);
        commune.put("ile des pins", Commune.ILE_DES_PINS);
        commune.put("dumbea", Commune.DUMBEA);
        commune.put("bourail", Commune.BOURAIL);
        commune.put("canala", Commune.CANALA);
        commune.put("fayaoue", Commune.FAYAOUE);
        commune.put("poum", Commune.POUM);
        commune.put("touho", Commune.TOUHO);
        commune.put("pouembout", Commune.POUEMBOUT);
        commune.put("koumac", Commune.KOUMAC);
        commune.put("paita", Commune.PAITA);
        commune.put("sarramea", Commune.SARRAMEA);
        commune.put("lifou", Commune.LIFOU);
        commune.put("ouegoa", Commune.OUEGOA);
        commune.put("yate", Commune.YATE);
        commune.put("la foa", Commune.LA_FOA);
        commune.put("hienghene", Commune.HIENGHENE);
        commune.put("mare", Commune.MARE);
        commune.put("poindimie", Commune.POINDIMIE);
        commune.put("ponerihouen", Commune.PONERIHOUEN);
        commune.put("voh", Commune.VOH);

        if (communeName == null) {
            logger.error("<" + communeName + "> ne correspond à aucune commune.");
            return null;
        }
        if (communeName == "") {
            logger.error("<" + communeName + "> ne correspond à aucune commune.");
            return null;
        }

        if (commune.containsKey(StringUtils.stripAccents(communeName.toLowerCase()))) {
            logger.info("correspondance trouvée pour <" + communeName + "> : <" + commune.get(StringUtils.stripAccents(communeName.toLowerCase())) + ">");
            return commune.get(communeName);
        } else {
            logger.error("" + communeName + " ne correspond à aucune commune.");
            return null;
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

        if (commune == null) {
            logger.error("Commune incorrecte.");
            return listeAgences;
        }

        logger.info("Recherche de l'URL : ");
        URL url = new URL("" + BASE_URL + Agences.getUrl(commune));

        logger.info("Recupération des données des agences : ");
        JsonNode jsonNode = mapper.readValue(url, JsonNode.class);
        int total = jsonNode.get("hits").get("total").asInt();

        logger.info("Recherche des agences de " + commune.name() + " : " + total + " résultats.");

        for (int i = 0; i < total; i++) {

            try {
                int idAgence = jsonNode.get("hits").get("hits").get(i).get("_source").get("id").asInt();
                String designation = jsonNode.get("hits").get("hits").get(i).get("_source").get("designation").asText();
                long realMaxWaitingTimeMs = ConvertToMillis(jsonNode.get("hits").get("hits").get(i).get("_source").get("borneEsirius").get("realMaxWaitingTime").asText());
                String coordonneesXY = jsonNode.get("hits").get("hits").get(i).get("_source").get("coordonneesXyRefloc").asText();
                JsonNode nodeCoordonneesXYPrecises = jsonNode.get("hits").get("hits").get(i).get("_source").get("coordonneesXyPrecisesRefloc");

                String[] tcoordonneesXY = coordonneesXY.split(";");
                double coordonneeX = Double.parseDouble(tcoordonneesXY[0]);
                double coordonneeY = Double.parseDouble(tcoordonneesXY[1]);

                long[] tCoordonneesXYPrecises = Agences.getCoordonneesXYPrecises(nodeCoordonneesXYPrecises);
                long coordonneeXPrecise = tCoordonneesXYPrecises[0];
                long coordonneeYPrecise = tCoordonneesXYPrecises[1];

                Agence agence = new Agence(idAgence, designation, realMaxWaitingTimeMs, coordonneeX, coordonneeY, coordonneeXPrecise, coordonneeYPrecise);
                listeAgences.add(agence);

                logger.info("Agence : " + agence.toString());

            } catch (Exception e) {

                int idAgence = jsonNode.get("hits").get("hits").get(i).get("_source").get("id").asInt();
                String designation = jsonNode.get("hits").get("hits").get(i).get("_source").get("designation").asText();
                String coordonneesXY = jsonNode.get("hits").get("hits").get(i).get("_source").get("coordonneesXyRefloc").asText();
                JsonNode nodeCoordonneesXYPrecises = jsonNode.get("hits").get("hits").get(i).get("_source").get("coordonneesXyPrecisesRefloc");

                logger.warn("Le temps d'attente maximum de l'agence <" + designation + "> est introuvable...");

                String[] tcoordonneesXY = coordonneesXY.split(";");
                double coordonneeX = Double.parseDouble(tcoordonneesXY[0]);
                double coordonneeY = Double.parseDouble(tcoordonneesXY[1]);

                try {
                    long[] tCoordonneesXYPrecises = Agences.getCoordonneesXYPrecises(nodeCoordonneesXYPrecises);
                    long coordonneeXPrecise = tCoordonneesXYPrecises[0];
                    long coordonneeYPrecise = tCoordonneesXYPrecises[1];

                    Agence agence = new Agence(idAgence, designation, 0, coordonneeX, coordonneeY, coordonneeXPrecise, coordonneeYPrecise);
                    listeAgences.add(agence);

                    logger.info("Agence : " + agence.toString());

                } catch (Exception ex) {
                    Agence agence = new Agence(idAgence, designation, 0, coordonneeX, coordonneeY, 0, 0);
                    listeAgences.add(agence);

                    logger.info("Agence : " + agence.toString());
                }

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

    public static long[] getCoordonneesXYPrecises(JsonNode nodeCoordonnesXYPrecises) {
        if (nodeCoordonnesXYPrecises.isNull()) {
            return null;
        } else {
            String strCoordonneesXYPrecises = nodeCoordonnesXYPrecises.asText();
            if ("".equals(strCoordonneesXYPrecises)) {
                return null;
            } else {
                String[] tStrCoordonneesXYPrecises = strCoordonneesXYPrecises.split(",");
                long[] tCoordonneesXYPrecises = {Long.parseLong(tStrCoordonneesXYPrecises[0]), Long.parseLong(tStrCoordonneesXYPrecises[1])};
                return tCoordonneesXYPrecises;
            }
        }
    }

}
