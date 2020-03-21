/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.opt.tempsattente.sdk;

import static com.github.adriens.opt.tempsattente.sdk.Agences.logger;
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
    public Agence(int idAgence, String designation, long realMaxWaitingTimeMs, double coordonneeX, double coordonneeY, long coordonneeXPrecise, long coordonneeYPrecise) {
        this.idAgence = idAgence;
        this.designation = designation;
        this.realMaxWaitingTimeMs = realMaxWaitingTimeMs;
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
        this.coordonneeXPrecise = coordonneeXPrecise;
        this.coordonneeYPrecise = coordonneeYPrecise;
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
                + ">";
    }

}
