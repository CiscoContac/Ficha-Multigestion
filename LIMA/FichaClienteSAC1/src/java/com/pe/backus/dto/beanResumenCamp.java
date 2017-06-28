/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.backus.dto;

/**
 *
 * @author Administrador
 */
public class beanResumenCamp {
     private String total_records;
     private String voice;
     private String available;
     private String closed;
     private String callback;

    /**
     * @return the total_records
     */
    public String getTotal_records() {
        return total_records;
    }

    /**
     * @param total_records the total_records to set
     */
    public void setTotal_records(String total_records) {
        this.total_records = total_records;
    }

    /**
     * @return the voice
     */
    public String getVoice() {
        return voice;
    }

    /**
     * @param voice the voice to set
     */
    public void setVoice(String voice) {
        this.voice = voice;
    }

    /**
     * @return the available
     */
    public String getAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(String available) {
        this.available = available;
    }

    /**
     * @return the closed
     */
    public String getClosed() {
        return closed;
    }

    /**
     * @param closed the closed to set
     */
    public void setClosed(String closed) {
        this.closed = closed;
    }

    /**
     * @return the callback
     */
    public String getCallback() {
        return callback;
    }

    /**
     * @param callback the callback to set
     */
    public void setCallback(String callback) {
        this.callback = callback;
    }
}
