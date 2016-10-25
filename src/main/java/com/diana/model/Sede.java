package com.diana.model;

import java.io.Serializable;

/**
 *
 * @author diana
 */

public class Sede implements Serializable {
	// Define the fields in the data base and the ones used to establish the relationship
    private Integer ano;
    private Tipo tipo;
    private Ciudad ciudad;
    
    // Getter and setter for ano, the name of the function should be the name of the variable defined at the beginning
    public Integer getAno(){
        return ano;
    }
    
    public void setAno(Integer ano){
        this.ano = ano;
    }
    
    // Getter and setter for tipo, these are functions of the type Tipo
    public Tipo getTipo(){
        return tipo;
    }
    
    public void setTipo(Tipo tipo){
        this.tipo = tipo;
    }
    
    // Getter and setter for sede, these are functions of the type Ciudad
    public Ciudad getCiudad(){
        return ciudad;
    }
    
    public void setCiudad(Ciudad ciudad){
        this.ciudad = ciudad;
    }
}
