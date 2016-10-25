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
	
	// Define the fields in the data base, integer fields were defined as Integer because some of them are NULL
    private Integer id;
    private String nombreCiudad;
    private Pais pais;
    private Integer valorCiudad;
    
    public Ciudad() {
	}

    // Constructor for Ciudad
	public Ciudad(Pais pais) {
		this.pais = pais;
	}

	public Ciudad(Pais pais, String nombreCiudad) {
		this.pais = pais;
		this.nombreCiudad = nombreCiudad;
	}
    
	// Getter and setter for id, the name of the function should be the name of the variable defined at the beginning
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer ID_CIUDAD){
        this.id = ID_CIUDAD;
    }
    
    // Getter and setter for NombreCiudad
    public String getNombreCiudad(){
        return nombreCiudad;
    }
    
    public void setNombreCiudad(String nombreCiudad){
        this.nombreCiudad = nombreCiudad;
    }
    
    // Getter and setter for Pais, these are functions of the type Pais
    public Pais getPais(){
        return pais;
    }
    
    public void setPais(Pais pais){
        this.pais = pais;
    }
    
    // Getter and setter for ValorCiudad, this can return a NULL value
    public Integer getValorCiudad(){
        return valorCiudad;
    }
    
    public void setValorCiudad(Integer valorCiudad){
        this.valorCiudad = valorCiudad;
    }
    
    
}