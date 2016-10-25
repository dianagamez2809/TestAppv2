/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diana.dao;

import com.diana.model.Ciudad;
import com.diana.model.Pais;
import com.diana.util.HibernateUtil;
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
	public void listCiudades( ){
			//Open a session of hibernate
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         // Query from  table 'Ciudad'
	         List ciudades = session.createQuery("FROM Ciudad Join Pais").list(); 
	         for (Iterator iterator = 
	                           ciudades.iterator(); iterator.hasNext();){
	            Ciudad ciudad = (Ciudad) iterator.next(); 
	            // Get the name of the country for each city
	            Pais pais = ciudad.getPais();
	            System.out.println("Ciudad: " + ciudad.getNombreCiudad());            
	            System.out.println("\tPais: " +  pais.getNombrePais());
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	    	 session.flush();
	         session.close(); 
	      }
	   }
	
	public List<Ciudad> getAllCiudades() {
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            ciudades = session.createQuery("from Ciudad").list();
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
