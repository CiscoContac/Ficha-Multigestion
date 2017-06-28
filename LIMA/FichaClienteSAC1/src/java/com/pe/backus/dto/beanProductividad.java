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
public class beanProductividad {
     //select Dessubmodelo,venta,valcapacidad from tabla_productividad_bo 
    private String Dessubmodelo;
    private String venta;
    private String Valcapacidad;
    private String Deslogo;
    private String productividad;
    private String numero_serie;

    /**
     * @return the Dessubmodelo
     */
    public String getDessubmodelo() {
        return Dessubmodelo;
    }

    /**
     * @param Dessubmodelo the Dessubmodelo to set
     */
    public void setDessubmodelo(String Dessubmodelo) {
        this.Dessubmodelo = Dessubmodelo;
    }

    /**
     * @return the venta
     */
    public String getVenta() {
        return venta;
    }

    /**
     * @param venta the venta to set
     */
    public void setVenta(String venta) {
        this.venta = venta;
    }

    /**
     * @return the Valcapacidad
     */
    public String getValcapacidad() {
        return Valcapacidad;
    }

    /**
     * @param Valcapacidad the Valcapacidad to set
     */
    public void setValcapacidad(String Valcapacidad) {
        this.Valcapacidad = Valcapacidad;
    }

    /**
     * @return the Deslogo
     */
    public String getDeslogo() {
        return Deslogo;
    }

    /**
     * @param Deslogo the Deslogo to set
     */
    public void setDeslogo(String Deslogo) {
        this.Deslogo = Deslogo;
    }

    /**
     * @return the productividad
     */
    public String getProductividad() {
        return productividad;
    }

    /**
     * @param productividad the productividad to set
     */
    public void setProductividad(String productividad) {
        this.productividad = productividad;
    }

    /**
     * @return the numero_serie
     */
    public String getNumero_serie() {
        return numero_serie;
    }

    /**
     * @param numero_serie the numero_serie to set
     */
    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }
}
