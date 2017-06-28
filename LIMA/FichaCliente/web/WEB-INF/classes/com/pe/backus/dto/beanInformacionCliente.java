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
public class beanInformacionCliente {
    private String codCliente;
    private String mensaje;
    private String Inicio;
    private String Fin;

    /**
     * @return the codCliente
     */
    public String getCodCliente() {
        return codCliente;
    }

    /**
     * @param codCliente the codCliente to set
     */
    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the Inicio
     */
    public String getInicio() {
        return Inicio;
    }

    /**
     * @param Inicio the Inicio to set
     */
    public void setInicio(String Inicio) {
        this.Inicio = Inicio;
    }

    /**
     * @return the Fin
     */
    public String getFin() {
        return Fin;
    }

    /**
     * @param Fin the Fin to set
     */
    public void setFin(String Fin) {
        this.Fin = Fin;
    }
    
}
