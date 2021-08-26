/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nc.opt.tempsattente;

import static nc.opt.tempsattente.Agences.logger;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author meilie
 * <br>
 * <p>
 * A <code><b>Agence</b></code> object represents an agency.
 * </p>
 *
 */
public class Agence {

    private int idAgence;
    private String designation;
    private long realMaxWaitingTimeMs;
    private double coordonneeX;
    private double coordonneeY;
    private long coordonneeXPrecise;
    private long coordonneeYPrecise;
    private String commune;
    private String type;
    private String codeESirius;
    private String codePostal;
    private String lieuDitOuTribu;
    private String localite;
    private String idRefloc;
    private String codePostalRefloc;
    private String localiteRefloc;

    /**
     * Default constructor.
     */
    public Agence() {
        this.idAgence = 0;
        this.designation = "";
        this.realMaxWaitingTimeMs = 0;
        this.coordonneeX = 0;
        this.coordonneeY = 0;
        this.coordonneeXPrecise = 0;
        this.coordonneeYPrecise = 0;
        this.commune = "";
        this.type = "";
        this.codeESirius = "";
        this.codePostal = "";
        this.lieuDitOuTribu = "";
        this.localite = "";
        this.idRefloc = "";
        this.codePostalRefloc = "";
        this.localiteRefloc = "";
    }

    /**
     * Contructor.
     *
     * @param idAgence The agency's ID number as text.
     * @param designation The agency's designation name.
     * @param realMaxWaitingTimeMs the maximum waiting time in the agency.
     * @param coordonneeX the agency's X coordinate.
     * @param coordonneeY the agency's Y coordinate.
     * @param coordonneeXPrecise the precise X coordinate of the agency.
     * @param coordonneeYPrecise the precise Y coordinate of the agency.
     */
    public Agence(int idAgence, String designation, long realMaxWaitingTimeMs, double coordonneeX, double coordonneeY, long coordonneeXPrecise, long coordonneeYPrecise, String commune, String type, String codeESirius, String codePostal, String lieuDitOuTribu, String localite, String idRefloc, String codePostalRefloc, String localiteRefloc) {
        this.idAgence = idAgence;
        this.designation = designation;
        this.realMaxWaitingTimeMs = realMaxWaitingTimeMs;
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
        this.coordonneeXPrecise = coordonneeXPrecise;
        this.coordonneeYPrecise = coordonneeYPrecise;
        this.commune = commune;
        this.type = type;
        this.codeESirius = codeESirius;
        this.codePostal = codePostal;
        this.lieuDitOuTribu = lieuDitOuTribu;
        this.localite = localite;
        this.idRefloc = idRefloc;
        this.codePostalRefloc = codePostalRefloc;
        this.localiteRefloc = localiteRefloc;
    }

    /**
     * Return the agency's ID number as text.
     *
     * @return the agency's ID number.
     */
    public int getIdAgence() {
        return this.idAgence;
    }

    /**
     * Return the agency's designation name.
     *
     * @return the agencey's designation name.
     */
    public String getDesignation() {
        return this.designation;
    }

    /**
     * Return the maximum waiting time in the agency.
     *
     * @return the maximum waiting time in the agency.
     */
    public long getRealMaxWaitingTimeMs() {
        return this.realMaxWaitingTimeMs;
    }

    /**
     * Return the agency's X coordinate.
     * 
     * @return the agency's X coordinate.
     */
    public double getCoordonneeX() {
        return this.coordonneeX;
    }

    /**
     * Return the agency's Y coordinate.
     * 
     * @return the agency's Y coordinate.
     */
    public double getCoordonneeY() {
        return this.coordonneeY;
    }

    /**
     * Return the precise X coordinate of the agency.
     * 
     * @return the precise X coordinate of the agency.
     */
    public long getCoordonneeXPrecise() {
        return this.coordonneeXPrecise;
    }

    /**
     * Return the precise Y coordinate of the agency.
     * 
     * @return the precise Y coordinate of the agency.
     */
    public long getCoordonneeYPrecise() {
        return this.coordonneeYPrecise;
    }

    /**
     * Return the commune of the agency.
     *
     * @return the commune of the agency.
     */
    public String getCommune() {
        return this.commune;
    }

    /**
     * Return the type of the agency.
     *
     * @return the type of the agency.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Return the Esirius code of the agency.
     *
     * @return the Esirius code of the agency.
     */
    public String getCodeESirius() {
        return this.codeESirius;
    }

    /**
     * Return the postal code of the agency.
     *
     * @return the postal code of the agency.
     */
    public String getCodePostal() {
        return this.codePostal;
    }

    /**
     * Return the locality or tribe of the agency.
     *
     * @return the locality or tribe of the agency.
     */
    public String getLieuDitOuTribu() {
        return this.lieuDitOuTribu;
    }

    /**
     * Return the locality of the agency.
     *
     * @return the locality of the agency.
     */
    public String getLocalite() {
        return this.localite;
    }

    /**
     * Return the refloc id of the agency.
     *
     * @return the refloc id of the agency.
     */
    public String getIdRefloc() {
        return this.idRefloc;
    }

    /**
     * Return the refloc postal code of the agency.
     *
     * @return the refloc postal code of the agency.
     */
    public String getCodePostalRefloc() {
        return this.codePostalRefloc;
    }

    /**
     * Return the refloc locality of the agency.
     *
     * @return the refloc locality of the agency.
     */
    public String getLocaliteRefloc() {
        return this.localiteRefloc;
    }

    /**
     * Set the agency's ID number.
     *
     * @param idAgence the agency's ID number as text.
     */
    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    /**
     * Set the agency's designation name.
     *
     * @param designation The angency's designation name.
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Set the maximum waiting time in the agency.
     *
     * @param realMaxWaitingTimeMs The maximum waiting time in the agency.
     */
    public void setRealMaxWaitingTimeMs(long realMaxWaitingTimeMs) {
        this.realMaxWaitingTimeMs = realMaxWaitingTimeMs;
    }

    /**
     * Set the agency's X coordinate.
     * 
     * @param coordonneeX the agency's X coordinate.
     */
    public void setCoordonneeX(double coordonneeX) {
        this.coordonneeX = coordonneeX;
    }

    /**
     * Set the agency's Y coordinate.
     * 
     * @param coordonneeY the agency's Y coordinate.
     */
    public void setCoordonneeY(double coordonneeY) {
        this.coordonneeY = coordonneeY;
    }

    /**
     * Set the precise X coordinate of the agency.
     * 
     * @param coordonneeXPrecise the precise X coordinate of the agency.
     */
    public void setCoordonneeXPrecise(long coordonneeXPrecise) {
        this.coordonneeXPrecise = coordonneeXPrecise;
    }

    /**
     * Set the precise Y coordinate of the agency.
     * @param coordonneeYPrecise the precise Y coordinate of the agency.
     */
    public void setCoordonneeYPrecise(long coordonneeYPrecise) {
        this.coordonneeYPrecise = coordonneeYPrecise;
    }

    /**
     * Set the commune of the agency.
     * @param commune the type of the agency.
     */
    public void setCommune(String commune) {
        this.commune = commune;
    }

    /**
     * Set the type of the agency.
     * @param type the type of the agency.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Set the Esirius code of the agency.
     * @param codeESirius the Esirius code of the agency.
     */
    public void setCodeESirius(String codeESirius) {
        this.codeESirius = codeESirius;
    }

    /**
     * Set the postal code of the agency.
     * @param codePostal the postal code of the agency.
     */
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * Set the locality or tribe of the agency.
     * @param lieuDitOuTribu the locality or tribe of the agency.
     */
    public void setLieuDitOuTribu(String lieuDitOuTribu) {
        this.lieuDitOuTribu = lieuDitOuTribu;
    }

    /**
     * Set the locality of the agency.
     * @param localite the locality of the agency.
     */
    public void setLocalite(String localite) {
        this.localite = localite;
    }

    /**
     * Set the refloc id of the agency.
     * @param idRefloc the refloc id of the agency.
     */
    public void setIdRefloc(String idRefloc) {
        this.idRefloc = idRefloc;
    }

    /**
     * Set the refloc postal code of the agency.
     * @param codePostalRefloc the refloc postal code of the agency.
     */
    public void setCodePostalRefloc(String codePostalRefloc) {
        this.codePostalRefloc = codePostalRefloc;
    }

    /**
     * Set the refloc locality of the agency.
     * @param localiteRefloc the refloc locality of the agency.
     */
    public void setLocaliteRefloc(String localiteRefloc) {
        this.localiteRefloc = localiteRefloc;
    }

    /**
     * Return the agency with the ID number in parameter.
     *
     * @param idAgence An angency's ID nuber as text.
     * @return the agency with the ID number in parameter.
     * @throws IOException
     */
    public static Agence getAgence(int idAgence) throws IOException {
        ArrayList<Agence> agences = Agences.getAgences();
        Agence result = new Agence();

        for (Agence agence : agences) {
            if (agence.idAgence == idAgence) {
                result = agence;
            }
        }

        if (result.idAgence == idAgence) {
            logger.info("correspondance trouvée pour " + idAgence + " : " + result.toString());
            return result;
        } else {
            logger.info("Aucune correspondance pour " + idAgence);
            return null;
        }

    }

    /**
     * Return the agency object, as text.
     *
     * @return the agency object, as text.
     */
    @Override
    public String toString() {
        return "Agence " + this.idAgence
                + " <designation: " + this.designation
                + ", realMaxWaitingTimeMs: " + this.realMaxWaitingTimeMs
                + ", coordonneeX: " + this.coordonneeX
                + ", coordonneeY: " + this.coordonneeY
                + ", coordonneeXPrecise: " + this.coordonneeXPrecise
                + ", coordonneeYPrecise: " + this.coordonneeYPrecise
                + ", commune: " + this.commune
                + ", type: " + this.type
                + ", codeESirius: " + this.codeESirius
                + ", codePostal: " + this.codePostal
                + ", lieuDitOuTribu: " + this.lieuDitOuTribu
                + ", localite: " + this.localite
                + ", idRefloc: " + this.idRefloc
                + ", codePostalRefloc: " + this.codePostalRefloc
                + ", localiteRefloc: " + this.localiteRefloc
                + ">";
    }

}
