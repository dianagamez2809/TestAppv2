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

public class Ciudad implements Serializable{

    private Integer id;
    private String nombreCiudad;
    private Pais pais;
    private Integer valorCiudad;
    
    public Ciudad() {
	}

	public Ciudad(Pais pais) {
		this.pais = pais;
	}

	public Ciudad(Pais pais, String nombreCiudad) {
		this.pais = pais;
		this.nombreCiudad = nombreCiudad;
	}
    
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer ID_CIUDAD){
        this.id = ID_CIUDAD;
    }
    
    public String getNombreCiudad(){
        return nombreCiudad;
    }
    
    public void setNombreCiudad(String nombreCiudad){
        this.nombreCiudad = nombreCiudad;
    }
    
    public Pais getPais(){
        return pais;
    }
    
    public void setPais(Pais pais){
        this.pais = pais;
    }
    
    public Integer getValorCiudad(){
        return valorCiudad;
    }
    
    public void setValorCiudad(Integer valorCiudad){
        this.valorCiudad = valorCiudad;
    }
    
    
}