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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    private static final String HYPHEN_SEPARATOR = "------------------------------------------------------------";

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
        VOH,
        TONTOUTA
        
    }

    /**
     * Return the query url, as text, for the Commune.
     *
     * @param commune a location.
     * @return the url as text.
     */
    public static String getUrl(Commune commune) {
        
        logger.info("Récupération de l'url de la commune: <" +commune+ ">");
        
        String url = "";

        if ("BOULOUPARIS".equals(commune.name())) url = "&q=localiteRefloc:(BOULOUPARIS)";
        if ("MOINDOU".equals(commune.name())) url = "&q=localiteRefloc:(MOINDOU)";
        if ("NOUMEA".equals(commune.name())) url = "&q=localiteRefloc:(NOUMEA)";
        if ("HOUAILOU".equals(commune.name())) url = "&q=localiteRefloc:(HOUAILOU)";
        if ("KONE".equals(commune.name())) url = "&q=localiteRefloc:(KONE)";
        if ("KAALA_GOMEN".equals(commune.name())) url = "&q=localiteRefloc:(KAALA-GOMEN)";
        if ("POUEBO".equals(commune.name())) url = "&q=localiteRefloc:(POUEBO)";
        if ("THIO".equals(commune.name())) url = "&q=localiteRefloc:(THIO)";
        if ("TADINE".equals(commune.name())) url = "&q=localiteRefloc:(TADINE)";
        if ("MONT_DORE".equals(commune.name())) url = "&q=localiteRefloc:(MONT-DORE)";
        if ("KOUAOUA".equals(commune.name())) url = "&q=localiteRefloc:(KOUAOUA)";
        if ("POYA".equals(commune.name())) url = "&q=localiteRefloc:(POYA)";
        if ("BELEP".equals(commune.name())) url = "&q=localiteRefloc:(BELEP)";
        if ("ILE_DES_PINS".equals(commune.name())) url = "&q=localiteRefloc:(ILE%20AND%20DES%20AND%20PINS)";
        if ("DUMBEA".equals(commune.name())) url = "&q=localiteRefloc:(DUMBEA)";
        if ("BOURAIL".equals(commune.name())) url = "&q=localiteRefloc:(BOURAIL)";
        if ("CANALA".equals(commune.name())) url = "&q=localiteRefloc:(CANALA)";
        if ("FAYAOUE".equals(commune.name())) url = "&q=localiteRefloc:(FAYAOUE)";
        if ("POUM".equals(commune.name())) url = "&q=localiteRefloc:(POUM)";
        if ("TOUHO".equals(commune.name())) url = "&q=localiteRefloc:(TOUHO)";
        if ("POUEMBOUT".equals(commune.name())) url = "&q=localiteRefloc:(POUEMBOUT)";
        if ("KOUMAC".equals(commune.name())) url = "&q=localiteRefloc:(KOUMAC)";
        if ("PAITA".equals(commune.name())) url = "&q=localiteRefloc:(PAITA)";
        if ("SARRAMEA".equals(commune.name())) url = "&q=localiteRefloc:(SARRAMEA)";
        if ("LIFOU".equals(commune.name())) url = "&q=localiteRefloc:(LIFOU)%20OR%20localiteRefloc:(WE)";
        if ("OUEGOA".equals(commune.name())) url = "&q=localiteRefloc:(OUEGOA)";
        if ("YATE".equals(commune.name())) url = "&q=localiteRefloc:(YATE)";
        if ("LA_FOA".equals(commune.name())) url = "&q=localiteRefloc:(LA%20AND%20FOA)";
        if ("HIENGHENE".equals(commune.name())) url = "&q=localiteRefloc:(HIENGHENE)";
        if ("MARE".equals(commune.name())) url = "&q=localiteRefloc:(MARE)";
        if ("POINDIMIE".equals(commune.name())) url = "&q=localiteRefloc:(POINDIMIE)";
        if ("PONERIHOUEN".equals(commune.name())) url = "&q=localiteRefloc:(PONERIHOUEN)"; 
        if ("VOH".equals(commune.name())) url = "&q=localiteRefloc:(VOH)";
        if ("TONTOUTA".equals(commune.name())) url = "&q=localiteRefloc:(TONTOUTA)";

        logger.info(HYPHEN_SEPARATOR);
        return url;
    }

    /**
     * Return the list of all the Commune as text.
     *
     * @return the list of Commune as text.
     */
    public static ArrayList<String> getCommunesNames() {

        logger.info("Récupération de la liste des communes");

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
        commune_map.put(Commune.TONTOUTA, "tontouta");

        for (Commune commune : Commune.values()) {
            logger.info("Ajout de la commune : " + commune_map.get(commune));
            commune_name.add(commune_map.get(commune));
        }
        logger.info("" + commune_name.size() + " communes ajoutées.");

        logger.info(HYPHEN_SEPARATOR);
        return commune_name;
    }

    /**
     * Return the Commune matching with the Commune name as text in parameter.
     *
     * @param communeName a Commune name, as text.
     * @return the Commune object with the name in parameter.
     */
    public static Commune getCommune(String communeName) {

        logger.info("Récupération de la commune: <" + communeName + ">");

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
        commune.put("tontouta", Commune.TONTOUTA);

        if (communeName == null) {
            logger.error("<" + communeName + "> ne correspond à aucune commune.");
            logger.info(HYPHEN_SEPARATOR);
            return null;
        }
        if ("".equals(communeName)) {
            logger.error("<" + communeName + "> ne correspond à aucune commune.");
            logger.info(HYPHEN_SEPARATOR);
            return null;
        }

        if (commune.containsKey(StringUtils.stripAccents(communeName.toLowerCase()))) {
            logger.info("correspondance trouvée pour <" + communeName + "> : <" + commune.get(StringUtils.stripAccents(communeName.toLowerCase())) + ">");
            logger.info(HYPHEN_SEPARATOR);
            return commune.get(communeName);
        } else {
            logger.error("" + communeName + " ne correspond à aucune commune.");
            logger.info(HYPHEN_SEPARATOR);
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

        logger.info("Récupération de la liste de toutes les agences");

        ArrayList<Agence> listeAgences = new ArrayList<>();

        logger.info("Recherche de l'URL : ");
        URL url = new URL(BASE_URL);

        logger.info("Recupération des données des agences : ");

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode jsonNode = mapper.readValue(url, JsonNode.class);
        int total = jsonNode.get("hits").get("total").asInt();

        ArrayList<Integer> ids = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            JsonNode nodeAgency = jsonNode.get("hits").get("hits").get(i).get("_source");
            ids.add(nodeAgency.get("id").asInt());
        }

        for (Commune value : Commune.values()) {
            ArrayList<Agence> listeAgences_commune = Agences.getAgences(value);
            listeAgences.addAll(listeAgences_commune);
        }

        for (Integer id : ids) {
          List<Agence> agence = listeAgences.stream().filter(a -> a.getIdAgence() == id).collect(Collectors.toList());
          if (agence.isEmpty()) {
              logger.error("Agence {} absent de la liste", id);
          }

        }

        logger.info(HYPHEN_SEPARATOR);
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

        logger.info("Récupération de la liste des agences de <{}>", commune);

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

        logger.info("{} résultats trouvés.", total);

        for (int i = 0; i < total; i++) {

            try {
                Agence agence = new Agence();
                JsonNode nodeAgency = jsonNode.get("hits").get("hits").get(i).get("_source");
                String[] coordonneesXY = Agences.getCoordonneesXY(nodeAgency.get("coordonneesXyRefloc"));

                agence.setCommune(commune.toString());
                agence.setIdAgence(nodeAgency.get("id").asInt());
                agence.setDesignation(nodeAgency.get("designation").asText());
                agence.setType(nodeAgency.get("type").asText());
                agence.setCodeESirius(nodeAgency.get("codeESirius").asText());
                agence.setIdRefloc(nodeAgency.get("idRefloc").asText());
                agence.setCodePostalRefloc(nodeAgency.get("codePostalRefloc").asText());
                agence.setCodePostal(nodeAgency.get("codePostal").asText());
                agence.setLieuDitOuTribu(nodeAgency.get("lieuDitOuTribu").asText());
                agence.setLocaliteRefloc(nodeAgency.get("localiteRefloc").asText());
                agence.setLocalite(nodeAgency.get("localite").asText());

                if (coordonneesXY != null) {
                    agence.setCoordonneeX(Double.parseDouble(coordonneesXY[0]));
                    agence.setCoordonneeY(Double.parseDouble(coordonneesXY[1]));
                }

                try {
                    agence.setRealMaxWaitingTimeMs(ConvertToMillis(nodeAgency.get("borneEsirius").get("realMaxWaitingTime").asText()));
                } catch (Exception e) {
                    logger.warn("Le temps d'attente maximum de l'agence <{}> est introuvable...", agence.getDesignation(), e);
                }

                try {
                    long[] coordonneesXYPrecises = Agences.getCoordonneesXYPrecises(nodeAgency.get("coordonneesXyPrecisesRefloc"));

                    if (coordonneesXYPrecises != null) {
                        agence.setCoordonneeXPrecise(coordonneesXYPrecises[0]);
                        agence.setCoordonneeXPrecise(coordonneesXYPrecises[1]);
                    }
                } catch (Exception e) {
                    logger.warn("Les coordonnées X et Y précises de l'agence <{}> sont introuvables...", agence.getDesignation(), e);
                }

                listeAgences.add(agence);

                logger.info("Agence : {}", agence.toString());

            } catch (Exception e) {
                logger.warn("Erreur lors de la récupération des informations...", e);
            }
        }

        if (listeAgences.size() != total)
            logger.warn("Erreur compteurs agences pour la comunne : {}", commune.toString());
        else
            logger.info("Compteurs agences OK pour la comunne : {}", commune.toString());

        logger.info(HYPHEN_SEPARATOR);
        return listeAgences;
    }

    /**
     * Convert duration as "HH:mm:ss" to milliseconds.
     *
     * @param duree A String duration.
     * @return the converted duration in milliseconds
     */
    public static long ConvertToMillis(String duree) {
        logger.info("Conversion de la duree en millisecondes");

        LocalTime duree_localTime = LocalTime.parse(duree, DateTimeFormatter.ISO_LOCAL_TIME);
        long millis = ChronoUnit.MILLIS.between(LocalTime.MIN, duree_localTime);

        logger.info(HYPHEN_SEPARATOR);
        return millis;
    }

    /**
     * Return the X and Y coordinates of the agency converted as string.
     *
     * @param nodeCoordonnesXY the node where the coordinate data is
     * located.
     * @return a array of the X and Y coordinates of the agency as String.
     */
    public static String[] getCoordonneesXY(JsonNode nodeCoordonnesXY) {
        return nodeCoordonnesXY == null ? null : nodeCoordonnesXY.asText().split(";");
    }

    /**
     * Return the precise X and Y coordinates of the agency converted as long.
     *
     * @param nodeCoordonnesXYPrecises the node where the coordinate data is
     * located.
     * @return a array of the precise X and Y coordinates of the agency as long.
     */
    public static long[] getCoordonneesXYPrecises(JsonNode nodeCoordonnesXYPrecises) {
        logger.info(HYPHEN_SEPARATOR);

        if (nodeCoordonnesXYPrecises.isNull()) {
            logger.info("coordonneesXyPrecises null");
            logger.info(HYPHEN_SEPARATOR);
            return null;
        } else {
            String strCoordonneesXYPrecises = nodeCoordonnesXYPrecises.asText();
            if ("".equals(strCoordonneesXYPrecises)) {
                logger.info("coordonneesXyPrecises vide");
                logger.info(HYPHEN_SEPARATOR);
                return null;
            } else {
                logger.info("coordonneesXyPrecises récupérées. conversion...");
                String[] tStrCoordonneesXYPrecises = strCoordonneesXYPrecises.split(",");
                long[] tCoordonneesXYPrecises = {Long.parseLong(tStrCoordonneesXYPrecises[0]), Long.parseLong(tStrCoordonneesXYPrecises[1])};
                logger.info(HYPHEN_SEPARATOR);
                return tCoordonneesXYPrecises;
            }
        }
    }

}
