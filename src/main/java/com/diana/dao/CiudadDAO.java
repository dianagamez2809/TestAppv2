/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diana.dao;

import com.diana.model.Ciudad;
import com.diana.model.Pais;
import com.diana.util.HibernateUtil;
import com.mysql.cj.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	public List listCiudades( ){
			//Open a session of hibernate
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      List ciudades = null;
	      try{
	         tx = session.beginTransaction();
	         // Query from  table 'Ciudad'
	         ciudades = session.createQuery("select c.id FROM Ciudad as c left join c.sedes").list();
	         //ciudades = session.createQuery("select p.id as id, p.nombrePais as pais FROM Pais as p join p.ciudades c left join c.sedes ").list();
	         for (Iterator iterator = 
	                           ciudades.iterator(); iterator.hasNext();){
	            Object ciudad = (Object) iterator.next(); 
	            // Get the name of the country for each city
	            //Pais pais = ciudad.getPais();
	            //Sede sede = ciudad
	            //Tipo tipo = tipo.
	            //System.out.println("ID_PAIS: " + (ciudad.toString());            
	            //System.out.println("\tPAIS: " +  pais.getNombrePais());
	            //System.out.println("ID_CIUDAD: " + ciudad.getId());            
	            //System.out.println("\tCIUDAD: " +  ciudad.getNombreCiudad());
	            //System.out.println("\tVALOR_CIUDAD: " +  ciudad.getValorCiudad());
	            
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
	
	public List<Ciudad> getAllCiudades() {
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            ciudades = session.createQuery("select c.id from Ciudad as c join c.sedes").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return ciudades;
    }
	
	
    
	// Function to get a city according to the id provided.
    public Ciudad getCiudadById(int idCiudad) {
        Ciudad ciudad = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Ciudad where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", idCiudad);
            ciudad = (Ciudad) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return ciudad;
    }
}
