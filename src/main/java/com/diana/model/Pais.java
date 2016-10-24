/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diana.model;

/**
 *
 * @author diana
 */
public class Pais {
	
    private Integer ID_PAIS;
    private String NOMBRE_PAIS;
    private String CODIGO_PAIS;
    private int VALOR_PAIS;
	
    

    public Integer getId() {
            return ID_PAIS;
    }

    public void setId(Integer ID_PAIS) {
            this.ID_PAIS = ID_PAIS;
    }

    public String getNombre() {
            return NOMBRE_PAIS;
    }

    public void setNombre(String NOMBRE_PAIS) {
            this.NOMBRE_PAIS = NOMBRE_PAIS;
    }
    
    public String getCodigo() {
            return CODIGO_PAIS;
    }

    public void setCodigo(String CODIGO_PAIS) {
            this.CODIGO_PAIS = CODIGO_PAIS;
    }
    
    public int getValor(){
        return VALOR_PAIS;
    }
    
    public void setValor(int VALOR_PAIS){
        this.VALOR_PAIS = VALOR_PAIS;
    }

    @Override
    public String toString(){
        return "Pais [ID_PAIS=" + ID_PAIS + 
                ", NOMBRE_PAIS =" + NOMBRE_PAIS +
                ", CODIGO_PAIS =" + CODIGO_PAIS +
                ", VALOR_PAIS =" + VALOR_PAIS + "]";
    }
}

