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
public class beanResultadoGestionSAC {
 private String Id;
 private String Tipo_Identificador;
 private String Identificador;
 private String Tipo_Cliente;
 private String Tipo_Llamada;
 private String Resultado_Contacto;
private String Tipificacion_Llamada;
 private String fecha;

    /**
     * @return the Tipo_Identificador
     */
    public String getTipo_Identificador() {
        return Tipo_Identificador;
    }

    /**
     * @param Tipo_Identificador the Tipo_Identificador to set
     */
    public void setTipo_Identificador(String Tipo_Identificador) {
        this.Tipo_Identificador = Tipo_Identificador;
    }

    /**
     * @return the Identificador
     */
    public String getIdentificador() {
        return Identificador;
    }

    /**
     * @param Identificador the Identificador to set
     */
    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }

    /**
     * @return the Tipo_Cliente
     */
    public String getTipo_Cliente() {
        return Tipo_Cliente;
    }

    /**
     * @param Tipo_Cliente the Tipo_Cliente to set
     */
    public void setTipo_Cliente(String Tipo_Cliente) {
        this.Tipo_Cliente = Tipo_Cliente;
    }

    /**
     * @return the Tipo_Llamada
     */
    public String getTipo_Llamada() {
        return Tipo_Llamada;
    }

    /**
     * @param Tipo_Llamada the Tipo_Llamada to set
     */
    public void setTipo_Llamada(String Tipo_Llamada) {
        this.Tipo_Llamada = Tipo_Llamada;
    }

    /**
     * @return the Resultado_Contacto
     */
    public String getResultado_Contacto() {
        return Resultado_Contacto;
    }

    /**
     * @param Resultado_Contacto the Resultado_Contacto to set
     */
    public void setResultado_Contacto(String Resultado_Contacto) {
        this.Resultado_Contacto = Resultado_Contacto;
    }

 
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
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return the Tipificacion_Llamada
     */
    public String getTipificacion_Llamada() {
        return Tipificacion_Llamada;
    }

    /**
     * @param Tipificacion_Llamada the Tipificacion_Llamada to set
     */
    public void setTipificacion_Llamada(String Tipificacion_Llamada) {
        this.Tipificacion_Llamada = Tipificacion_Llamada;
    }
}
