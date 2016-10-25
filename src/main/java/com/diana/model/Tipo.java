package com.diana.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author diana
 */
public class Tipo implements Serializable {
	// Define the fields in the data base, the SET variable is used to establish the one to many relationship
    private Integer id;
    private String descripcion;
	private Set<Sede> sedes = new HashSet<Sede>(0);
	
	// Getter and setter for id, the name of the function should be the name of the variable defined at the beginning
    public Integer getId() {
            return id;
    }

    public void setId(Integer id) {
            this.id = id;
    }
    
    // Getter and setter for Sedes, these methods are of Sede type
    public Set<Sede> getSedes(){
    	return this.sedes;
    }
    
    public void setSedes(Set<Sede> sedes){
    	this.sedes = sedes;
    }
}
