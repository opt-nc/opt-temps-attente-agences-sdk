/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nc.opt.tempsattente;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        String url = "";

        if (Commune.BOULOUPARIS == commune) url = "&q=localiteRefloc:(BOULOUPARIS)";
        if (Commune.MOINDOU == commune) url = "&q=localiteRefloc:(MOINDOU)";
        if (Commune.NOUMEA == commune) url = "&q=localiteRefloc:(NOUMEA)";
        if (Commune.HOUAILOU == commune) url = "&q=localiteRefloc:(HOUAILOU)";
        if (Commune.KONE == commune) url = "&q=localiteRefloc:(KONE)";
        if (Commune.KAALA_GOMEN == commune) url = "&q=localiteRefloc:(KAALA-GOMEN)";
        if (Commune.POUEBO == commune) url = "&q=localiteRefloc:(POUEBO)";
        if (Commune.THIO == commune) url = "&q=localiteRefloc:(THIO)";
        if (Commune.TADINE == commune) url = "&q=localiteRefloc:(TADINE)";
        if (Commune.MONT_DORE == commune) url = "&q=localiteRefloc:(MONT-DORE)";
        if (Commune.KOUAOUA == commune) url = "&q=localiteRefloc:(KOUAOUA)";
        if (Commune.POYA == commune) url = "&q=localiteRefloc:(POYA)";
        if (Commune.BELEP == commune) url = "&q=localiteRefloc:(BELEP)";
        if (Commune.ILE_DES_PINS == commune) url = "&q=localiteRefloc:(ILE%20AND%20DES%20AND%20PINS)";
        if (Commune.DUMBEA == commune) url = "&q=localiteRefloc:(DUMBEA)";
        if (Commune.BOURAIL == commune) url = "&q=localiteRefloc:(BOURAIL)";
        if (Commune.CANALA == commune) url = "&q=localiteRefloc:(CANALA)";
        if (Commune.FAYAOUE == commune) url = "&q=localiteRefloc:(FAYAOUE)";
        if (Commune.POUM == commune) url = "&q=localiteRefloc:(POUM)";
        if (Commune.TOUHO == commune) url = "&q=localiteRefloc:(TOUHO)";
        if (Commune.POUEMBOUT == commune) url = "&q=localiteRefloc:(POUEMBOUT)";
        if (Commune.KOUMAC == commune) url = "&q=localiteRefloc:(KOUMAC)";
        if (Commune.PAITA == commune) url = "&q=localiteRefloc:(PAITA)";
        if (Commune.SARRAMEA == commune) url = "&q=localiteRefloc:(SARRAMEA)";
        if (Commune.LIFOU == commune) url = "&q=localiteRefloc:(LIFOU)%20OR%20localiteRefloc:(WE)";
        if (Commune.OUEGOA == commune) url = "&q=localiteRefloc:(OUEGOA)";
        if (Commune.YATE == commune) url = "&q=localiteRefloc:(YATE)";
        if (Commune.LA_FOA == commune) url = "&q=localiteRefloc:(LA%20AND%20FOA)";
        if (Commune.HIENGHENE == commune) url = "&q=localiteRefloc:(HIENGHENE)";
        if (Commune.MARE == commune) url = "&q=localiteRefloc:(MARE)";
        if (Commune.POINDIMIE == commune) url = "&q=localiteRefloc:(POINDIMIE)";
        if (Commune.PONERIHOUEN == commune) url = "&q=localiteRefloc:(PONERIHOUEN)"; 
        if (Commune.VOH == commune) url = "&q=localiteRefloc:(VOH)";
        if (Commune.TONTOUTA == commune) url = "&q=localiteRefloc:(TONTOUTA)";

        logger.info("Récupération de l'url de la commune: <{}> : {}{}", commune, BASE_URL, url);
        return url;
    }

    /**
     * Return the list of all the Commune as text.
     *
     * @return the list of Commune as text.
     */
    public static List<String> getCommunesNames() {

        logger.info("Récupération de la liste des communes");

        ArrayList<String> communeNames = new ArrayList<>();

        EnumMap<Commune, String> communeMap = new EnumMap<>(Commune.class);

        communeMap.put(Commune.BOULOUPARIS, "boulouparis");
        communeMap.put(Commune.MOINDOU, "moindou");
        communeMap.put(Commune.NOUMEA, "noumea");
        communeMap.put(Commune.HOUAILOU, "houailou");
        communeMap.put(Commune.KONE, "kone");
        communeMap.put(Commune.KAALA_GOMEN, "kaala-gomen");
        communeMap.put(Commune.POUEBO, "pouebo");
        communeMap.put(Commune.THIO, "thio");
        communeMap.put(Commune.TADINE, "tadine");
        communeMap.put(Commune.MONT_DORE, "mont-dore");
        communeMap.put(Commune.KOUAOUA, "kouaoua");
        communeMap.put(Commune.POYA, "poya");
        communeMap.put(Commune.BELEP, "belep");
        communeMap.put(Commune.ILE_DES_PINS, "ile des pins");
        communeMap.put(Commune.DUMBEA, "dumbea");
        communeMap.put(Commune.BOURAIL, "bourail");
        communeMap.put(Commune.CANALA, "canala");
        communeMap.put(Commune.FAYAOUE, "fayaoue");
        communeMap.put(Commune.POUM, "poum");
        communeMap.put(Commune.TOUHO, "touho");
        communeMap.put(Commune.POUEMBOUT, "pouembout");
        communeMap.put(Commune.KOUMAC, "koumac");
        communeMap.put(Commune.PAITA, "paita");
        communeMap.put(Commune.SARRAMEA, "sarramea");
        communeMap.put(Commune.LIFOU, "lifou");
        communeMap.put(Commune.OUEGOA, "ouegoa");
        communeMap.put(Commune.YATE, "yate");
        communeMap.put(Commune.LA_FOA, "la foa");
        communeMap.put(Commune.HIENGHENE, "hienghene");
        communeMap.put(Commune.MARE, "mare");
        communeMap.put(Commune.POINDIMIE, "poindimie");
        communeMap.put(Commune.PONERIHOUEN, "ponerihouen");
        communeMap.put(Commune.VOH, "voh");
        communeMap.put(Commune.TONTOUTA, "tontouta");

        for (Commune commune : Commune.values()) {
            logger.info("Ajout de la commune : {}", communeMap.get(commune));
            communeNames.add(communeMap.get(commune));
        }
        logger.info("{} communes ajoutées.", communeNames.size());

        logger.info(HYPHEN_SEPARATOR);
        return communeNames;
    }

    /**
     * Return the Commune matching with the Commune name as text in parameter.
     *
     * @param communeName a Commune name, as text.
     * @return the Commune object with the name in parameter.
     */
    public static Commune getCommune(String communeName) {

        logger.info("Récupération de la commune: <{}>", communeName);

        HashMap<String, Commune> communes = new HashMap<>();

        communes.put("boulouparis", Commune.BOULOUPARIS);
        communes.put("moindou", Commune.MOINDOU);
        communes.put("noumea", Commune.NOUMEA);
        communes.put("houailou", Commune.HOUAILOU);
        communes.put("kone", Commune.KONE);
        communes.put("kaala-gomen", Commune.KAALA_GOMEN);
        communes.put("pouebo", Commune.POUEBO);
        communes.put("thio", Commune.THIO);
        communes.put("tadine", Commune.TADINE);
        communes.put("mont-dore", Commune.MONT_DORE);
        communes.put("kouaoua", Commune.KOUAOUA);
        communes.put("poya", Commune.POYA);
        communes.put("belep", Commune.BELEP);
        communes.put("ile des pins", Commune.ILE_DES_PINS);
        communes.put("dumbea", Commune.DUMBEA);
        communes.put("bourail", Commune.BOURAIL);
        communes.put("canala", Commune.CANALA);
        communes.put("fayaoue", Commune.FAYAOUE);
        communes.put("poum", Commune.POUM);
        communes.put("touho", Commune.TOUHO);
        communes.put("pouembout", Commune.POUEMBOUT);
        communes.put("koumac", Commune.KOUMAC);
        communes.put("paita", Commune.PAITA);
        communes.put("sarramea", Commune.SARRAMEA);
        communes.put("lifou", Commune.LIFOU);
        communes.put("ouegoa", Commune.OUEGOA);
        communes.put("yate", Commune.YATE);
        communes.put("la foa", Commune.LA_FOA);
        communes.put("hienghene", Commune.HIENGHENE);
        communes.put("mare", Commune.MARE);
        communes.put("poindimie", Commune.POINDIMIE);
        communes.put("ponerihouen", Commune.PONERIHOUEN);
        communes.put("voh", Commune.VOH);
        communes.put("tontouta", Commune.TONTOUTA);

        if (communeName == null) {
            logger.error("<{}> ne correspond à aucune commune.", communeName);
            logger.info(HYPHEN_SEPARATOR);
            return null;
        }
        if ("".equals(communeName)) {
            logger.error("<{}> ne correspond à aucune commune.", communeName);
            logger.info(HYPHEN_SEPARATOR);
            return null;
        }

        Commune commune = communes.get(StringUtils.stripAccents(communeName.toLowerCase(Locale.getDefault())));
        if (commune != null) {
            logger.info("correspondance trouvée pour <{}> : <{}>", communeName, commune);
            logger.info(HYPHEN_SEPARATOR);
            return commune;
        } else {
            logger.error("{} ne correspond à aucune commune.", communeName);
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
    public static List<Agence> getAgences() throws IOException {

        logger.info("Récupération de la liste de toutes les agences");

        return load(new URL("" + BASE_URL));
    }

    /**
     * Return the list of agencies for the Commune in parameter.
     *
     * @param commune the location zone of agencies.
     * @return the list of agencies for the Commune in parameter.
     * @throws IOException
     */
    public static List<Agence> getAgences(Commune commune) throws IOException {
 
        logger.info("Récupération de la liste des agences de <{}>", commune);

        if (commune == null) {
            logger.error("Commune incorrecte.");
            return Collections.emptyList();
        }
        
        return load(new URL("" + BASE_URL + Agences.getUrl(commune)));
    }

    /**
     * Return list of agencies within a given distance of a geopoint.
     * 
     * @param lon Longitude of geopoint
     * @param lat Latitude of geopoint
     * @param distanceInMeters Max distance in meters of geopoint
     */
    public static List<Agence> getAgencesByDistance(double lon, double lat, long distanceInMeters) throws IOException {

        String queryString = String.format(Locale.ENGLISH,
            "{\"query\":{\"geo_distance\": {\"distance\": \"%dm\",\"position\": {\"lat\": %f,\"lon\": %f}}}}", distanceInMeters, lat, lon);

        logger.info("Récupération de la liste des agences par distance {}", queryString);

        String url = BASE_URL
            + "&source_content_type=" + URLEncoder.encode("application/json", StandardCharsets.UTF_8.name())
            + "&source=" + URLEncoder.encode(queryString, StandardCharsets.UTF_8.name());

        return load(new URL(url));
    }

    private static List<Agence> load(URL url) throws IOException {
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode jsonNode = mapper.readValue(url, JsonNode.class);

        int total = jsonNode.get("hits").get("total").asInt();

        logger.info("{} résultats trouvés.", total);

        ArrayList<Agence> listeAgences = new ArrayList<>();
        for (int i = 0; i < total; i++) {

            try {
                Agence agence = new Agence();
                JsonNode nodeAgence = jsonNode.get("hits").get("hits").get(i).get("_source");

                agence.setCommune(Optional.ofNullable(nodeAgence.get("localiteRefloc")).map(n -> n.asText()).orElse(null));
                agence.setIdAgence(nodeAgence.get("id").asInt());
                agence.setDesignation(Optional.ofNullable(nodeAgence.get("designation")).map(n -> n.asText()).orElse(null));
                agence.setType(Optional.ofNullable(nodeAgence.get("type")).map(n -> n.asText()).orElse(null));
                agence.setCodeESirius(Optional.ofNullable(nodeAgence.get("codeESirius")).map(n -> n.asText()).orElse(null));
                agence.setIdRefloc(Optional.ofNullable(nodeAgence.get("idRefloc")).map(n -> n.asText()).orElse(null));
                agence.setCodePostalRefloc(Optional.ofNullable(nodeAgence.get("codePostalRefloc")).map(n -> n.asText()).orElse(null));
                agence.setCodePostal(Optional.ofNullable(nodeAgence.get("codePostal")).map(n -> n.asText()).orElse(null));
                agence.setLieuDitOuTribu(Optional.ofNullable(nodeAgence.get("lieuDitOuTribu")).map(n -> n.asText()).orElse(null));
                agence.setLocaliteRefloc(Optional.ofNullable(nodeAgence.get("localiteRefloc")).map(n -> n.asText()).orElse(null));
                agence.setLocalite(Optional.ofNullable(nodeAgence.get("localite")).map(n -> n.asText()).orElse(null));

                String[] coordonneesXY = Agences.getCoordonneesXY(nodeAgence.get("coordonneesXyRefloc"));
                if (coordonneesXY != null) {
                    agence.setCoordonneeX(Double.parseDouble(coordonneesXY[0]));
                    agence.setCoordonneeY(Double.parseDouble(coordonneesXY[1]));
                }

                JsonNode position = nodeAgence.findPath("position");
                if (!position.isEmpty()) {
                    agence.setPosition(new LonLat(position.get("lon").asDouble(), position.get("lat").asDouble()));
                }

                try {
                    agence.setRealMaxWaitingTimeMs(convertToMillis(nodeAgence.get("borneEsirius").get("realMaxWaitingTime").asText()));
                } catch (Exception e) {
                    logger.warn("Le temps d'attente maximum de l'agence <{}> est introuvable...", agence.getDesignation(), e);
                }

                try {
                    long[] coordonneesXYPrecises = Agences.getCoordonneesXYPrecises(nodeAgence.get("coordonneesXyPrecisesRefloc"));

                    if (coordonneesXYPrecises != null) {
                        agence.setCoordonneeXPrecise(coordonneesXYPrecises[0]);
                        agence.setCoordonneeYPrecise(coordonneesXYPrecises[1]);
                    }
                } catch (Exception e) {
                    logger.warn("Les coordonnées X et Y précises de l'agence <{}> sont introuvables...", agence.getDesignation(), e);
                }

                listeAgences.add(agence);
                logger.info("Agence <{}> : {}", agence.getIdAgence(), agence);

            } catch (Exception e) {
                logger.warn("Erreur lors de la récupération des informations...", e);
            }
        }

        logger.info(HYPHEN_SEPARATOR);
        return listeAgences;
    }

    /**
     * Convert duration as "HH:mm:ss" to milliseconds.
     *
     * @param duree A String duration.
     * @return the converted duration in milliseconds
     */
    public static long convertToMillis(String duree) {
        logger.info("Conversion de la duree en millisecondes");

        LocalTime localTime = LocalTime.parse(duree, DateTimeFormatter.ISO_LOCAL_TIME);
        return ChronoUnit.MILLIS.between(LocalTime.MIN, localTime);
    }

    /**
     * Return the X and Y coordinates of the agency converted as string.
     *
     * @param nodeCoordonnesXY the node where the coordinate data is
     * located.
     * @return a array of the X and Y coordinates of the agency as String.
     */
    public static String[] getCoordonneesXY(JsonNode nodeCoordonnesXY) {
        return nodeCoordonnesXY.isNull() ? null : nodeCoordonnesXY.asText().split(";");
    }

    /**
     * Return the precise X and Y coordinates of the agency converted as long.
     *
     * @param nodeCoordonnesXYPrecises the node where the coordinate data is
     * located.
     * @return a array of the precise X and Y coordinates of the agency as long.
     */
    public static long[] getCoordonneesXYPrecises(JsonNode nodeCoordonnesXYPrecises) {
        if (nodeCoordonnesXYPrecises.isNull()) {
            logger.info("coordonneesXyPrecises null");
            return null;
        } else {
            String strCoordonneesXYPrecises = nodeCoordonnesXYPrecises.asText();
            if ("".equals(strCoordonneesXYPrecises)) {
                logger.info("coordonneesXyPrecises vide");
                return null;
            } else {
                logger.info("coordonneesXyPrecises récupérées. conversion...");
                String[] tStrCoordonneesXYPrecises = strCoordonneesXYPrecises.split(",");
                long[] tCoordonneesXYPrecises = {Long.parseLong(tStrCoordonneesXYPrecises[0]), Long.parseLong(tStrCoordonneesXYPrecises[1])};
                return tCoordonneesXYPrecises;
            }
        }
    }

}
