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

    private String idAgence;
    private String designation;
    private long realMaxWaitingTime;

    /**
     * Default constructor.
     */
    public Agence() {
        this.idAgence = "";
        this.designation = "";
        this.realMaxWaitingTime = 0;
    }

    /**
     * Contructor.
     *
     * @param designation The agency's designation name.
     * @param realMaxWaitingTime the maximum waiting time in the agency.
     */
    public Agence(String idAgence, String designation, long realMaxWaitingTime) {
        this.idAgence = idAgence;
        this.designation = designation;
        this.realMaxWaitingTime = realMaxWaitingTime;
    }

    /**
     * Constructor.
     *
     * @param designation The agency's designation name.
     */
    public Agence(String idAgence, String designation) {
        this.idAgence = idAgence;
        this.designation = designation;
        this.realMaxWaitingTime = 0;
    }
    
    public String getIdAgence() {
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
    public long getRealMaxWaitingTime() {
        return this.realMaxWaitingTime;
    }
    
    public void setIdAgence(String idAgence) {
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
     * @param realMaxWaitingTime The maximum waiting time in the agency.
     */
    public void setRealMaxWaitingTime(long realMaxWaitingTime) {
        this.realMaxWaitingTime = realMaxWaitingTime;
    }
    
    public static Agence getAgence(String idAgence) throws IOException {
        ArrayList<Agence> agences = Agences.getAgences();
        Agence result = new Agence();
        
        for (Agence agence : agences) {
            if (agence.idAgence.equals(idAgence)) result = agence;
        }
        
        if (result.idAgence.equals(idAgence)) {
            logger.info("correspondance trouvée pour " +idAgence+ " : " +result.toString());
            return result;
        } else {
            logger.info("Aucune correspondance pour " +idAgence);
            return result;
        }
        
    }

    /**
     * Return the agency object, as text.
     *
     * @return the agency object, as text.
     */
    @Override
    public String toString() {
        return "Agence " + this.idAgence + " <designation: " + this.designation + ", realMaxWaitingTime: " + this.realMaxWaitingTime + ">";
    }

}
