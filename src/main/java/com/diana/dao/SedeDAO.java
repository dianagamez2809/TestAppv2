package com.diana.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.diana.model.Sede;
import com.diana.util.HibernateUtil;

public class SedeDAO {
	// Function to get the list of sedes
	public List<Sede> getSedes( ){
		//Open a session of hibernate
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      List<Sede> sedes = new ArrayList<Sede>();
      try{
         tx = session.beginTransaction();
         // Query from  table 'Sede'
         sedes = session.createQuery("FROM Sede").list();
         
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
    	 //session.flush();
         session.close(); 
      }
      return sedes;
   }
	
	// Function to get a sede according to the id provided.
    public Sede getSede(int idSede) {
    	Sede sitio = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Sede where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", idSede);
            sitio = (Sede) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return sitio;
    }
    
    public List<Sede> getAll() {
    	   
    	  // Retrieve session from Hibernate
    	  Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	   
    	  // Create a Hibernate query (HQL)
    	  Query query = session.createQuery("FROM  Sede");
    	   
    	  // Retrieve all
    	  return  query.list();
    	 }
    
    // Function to create a sede
    
    
    // Function to update a sede
    
    
    // Function to delete a sede
}
