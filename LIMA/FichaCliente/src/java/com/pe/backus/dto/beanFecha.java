/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pe.backus.dto;

/**
 *
 * @author GMD
 */
public class beanFecha {
    
    private String fecha;
    private String  Mes;
    private String MesDescripcion;
    private String  nroSemana;
    private int contador;
       private String anio ;

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the Mes
     */
    public String getMes() {
        return Mes;
    }

    /**
     * @param Mes the Mes to set
     */
    public void setMes(String Mes) {
        this.Mes = Mes;
    }

    /**
     * @return the MesDescripcion
     */
    public String getMesDescripcion() {
        return MesDescripcion;
    }

    /**
     * @param MesDescripcion the MesDescripcion to set
     */
    public void setMesDescripcion(String MesDescripcion) {
        this.MesDescripcion = MesDescripcion;
    }

    /**
     * @return the nroSemana
     */
    public String getNroSemana() {
        return nroSemana;
    }

    /**
     * @param nroSemana the nroSemana to set
     */
    public void setNroSemana(String nroSemana) {
        this.nroSemana = nroSemana;
    }

    /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(int contador) {
        this.contador = contador;
    }

    /**
     * @return the anio
     */
    public String getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(String anio) {
        this.anio = anio;
    }

   
}