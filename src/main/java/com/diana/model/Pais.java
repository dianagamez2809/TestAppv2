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
	
    private Integer id;
    private String nombrePais;
    private String codigoPais;
    private int valorPais;
	private Set<Ciudad> ciudades = new HashSet<Ciudad>(0);
    
	public Pais() {
	}

	public Pais(String nombrePais, String codigoPais, int valorPais) {
		this.nombrePais = nombrePais;
		this.codigoPais = codigoPais;
		this.valorPais = valorPais;
	}

	public Pais(String nombrePais, String codigoPais, int valorPais,
			Set<Ciudad> ciudades) {
		this.nombrePais = nombrePais;
		this.codigoPais = codigoPais;
		this.valorPais = valorPais;
		this.ciudades = ciudades;
	}
	
    public Integer getId() {
            return id;
    }

    public void setId(Integer id) {
            this.id = id;
    }

    public String getNombrePais() {
            return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
            this.nombrePais = nombrePais;
    }
    
    public String getCodigoPais() {
            return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
            this.codigoPais = codigoPais;
    }
    
    public int getValorPais(){
        return valorPais;
    }
    
    public void setValorPais(int valorPais){
        this.valorPais = valorPais;
    }
    
    public Set<Ciudad> getCiudades(){
    	return this.ciudades;
    }
    
    public void setCiudades(Set<Ciudad> ciudades){
    	this.ciudades = ciudades;
    }

    
}

