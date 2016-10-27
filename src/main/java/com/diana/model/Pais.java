/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diana.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author diana
 */
public class Pais implements Serializable {
	
	// Define the fields in the data base, the SET variable is used to establish the one to many relationship
    private Integer id;
    private String nombrePais;
    private String codigoPais;
    private Integer valorPais;
	private Set<Ciudad> ciudades = new HashSet<Ciudad>(0);
    
	
	// Constructor for Pais
	public Pais() {
	}

	public Pais(String nombrePais, String codigoPais, Integer valorPais) {
		this.nombrePais = nombrePais;
		this.codigoPais = codigoPais;
		this.valorPais = valorPais;
	}

	public Pais(String nombrePais, String codigoPais, Integer valorPais,
			Set<Ciudad> ciudades) {
		this.nombrePais = nombrePais;
		this.codigoPais = codigoPais;
		this.valorPais = valorPais;
		this.ciudades = ciudades;
	}
	
	// Getter and setter for id, the name of the function should be the name of the variable defined at the beginning
    public Integer getId() {
            return id;
    }

    public void setId(Integer id) {
            this.id = id;
    }

    // Getter and setter for NombrePais
    public String getNombrePais() {
            return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
            this.nombrePais = nombrePais;
    }
    
    // Getter and setter for CodigoPais
    public String getCodigoPais() {
            return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
            this.codigoPais = codigoPais;
    }
    
    // Getter and setter for ValorPais
    public Integer getValorPais(){
        return valorPais;
    }
    
    public void setValorPais(Integer valorPais){
        this.valorPais = valorPais;
    }
    
    // Getter and setter for Ciudades, these methods are of Ciudad type
    public Set<Ciudad> getCiudades(){
    	return this.ciudades;
    }
    
    public void setCiudades(Set<Ciudad> ciudades){
    	this.ciudades = ciudades;
    }

    
}

