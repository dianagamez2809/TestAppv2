/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diana.model;
import java.io.Serializable;

/**
 *
 * @author diana
 */

public class Ciudad{

    private int id;
    private String nombreCiudad;
    private int idPais;
    private int valorCiudad;
    
    public int getId(){
        return id;
    }
    
    public void setId(int ID_CIUDAD){
        this.id = ID_CIUDAD;
    }
    
    public String getNombreCiudad(){
        return nombreCiudad;
    }
    
    public void setNombreCiudad(String nombreCiudad){
        this.nombreCiudad = nombreCiudad;
    }
    
    public int getIdPais(){
        return idPais;
    }
    
    public void setIdPais(int idPais){
        this.idPais = idPais;
    }
    
    public int getValorCiudad(){
        return valorCiudad;
    }
    
    public void setValorCiudad(int valorCiudad){
        this.valorCiudad = valorCiudad;
    }
    
    @Override
    public String toString(){
        return "Ciudad [ID_CIUDAD=" + id + 
                ", NOMBRE_CIUDAD =" + nombreCiudad +
                ", ID_PAIS =" + idPais +
                ", VALOR_CIUDAD =" + valorCiudad + "]";
    }
}