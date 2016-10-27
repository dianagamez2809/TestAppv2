/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diana.dao;

import com.diana.model.Ciudad;
import com.diana.model.Pais;
import com.diana.model.Sede;
import com.diana.util.HibernateUtil;
import com.mysql.cj.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author diana
 */
public class CiudadDAO {
	
	// Function to retrieve the list of cities and countries
	public List<Ciudad> listCiudades( ){
			//Open a session of hibernate
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      List<Ciudad> ciudades = null;
	      try{
	         tx = session.beginTransaction();
	         // Query from  table 'Ciudad'
	         ciudades = session.createQuery("FROM Ciudad ").list();
	         //ciudades = session.createQuery("select p.id as id, p.nombrePais as pais FROM Pais as p join p.ciudades c left join c.sedes ").list();
	         for (Iterator iterator = 
	                           ciudades.iterator(); iterator.hasNext();){
	            Ciudad ciudad = (Ciudad) iterator.next(); 
	            Pais pais = ciudad.getPais();
	            pais.getNombrePais();
	            pais.getValorPais();
	            Set<Sede> sede = ciudad.getSedes();
	            sede.size();
	            
	            
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	    	 //session.flush();
	         session.close(); 
	      }
	      return ciudades;
	  }
	
	

}
