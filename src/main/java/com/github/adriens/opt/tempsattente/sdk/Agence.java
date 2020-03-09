/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.opt.tempsattente.sdk;

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

    private String designation;
    private long realMaxWaitingTime;

    /**
     * Default constructor.
     */
    public Agence() {
        this.designation = "";
        this.realMaxWaitingTime = 0;
    }

    /**
     * Contructor.
     *
     * @param designation The agency's designation name.
     * @param realMaxWaitingTime the maximum waiting time in the agency.
     */
    public Agence(String designation, long realMaxWaitingTime) {
        this.designation = designation;
        this.realMaxWaitingTime = realMaxWaitingTime;
    }

    /**
     * Constructor.
     *
     * @param designation The agency's designation name.
     */
    public Agence(String designation) {
        this.designation = designation;
        this.realMaxWaitingTime = 0;
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

    /**
     * Return the agency object, as text.
     *
     * @return the agency object, as text.
     */
    @Override
    public String toString() {
        return "designation: <" + this.designation + ">, realMaxWaitingTime: <" + this.realMaxWaitingTime + ">";
    }

}
