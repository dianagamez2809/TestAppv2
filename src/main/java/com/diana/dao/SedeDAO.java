package com.diana.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.diana.model.Ciudad;
import com.diana.model.Pais;
import com.diana.model.Sede;
import com.diana.model.Tipo;
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
         for (Iterator iterator = 
                 sedes.iterator(); iterator.hasNext();){
			  Sede sede = (Sede) iterator.next(); 
			  Ciudad ciudad = sede.getCiudad();
			  ciudad.getNombreCiudad();
			  Tipo tipo = sede.getTipo();
			  tipo.getDescripcion();
		 }
         
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
    public Sede getSede(int idSede, int tipo) {
    	Sede sede = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Sede where id = :idSede ";
            Query query = session.createQuery(queryString);
            query.setInteger("idSede", idSede);
            //query.setInteger("tipo", tipo);
            sede = (Sede) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return sede;
    }
    
   
    // Function to create a sede
    public void createSede(Sede sede) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(sede);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
    }
    
    // Function to update a sede
    public void updateSede(Sede sede) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(sede);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
    }
    
    // Function to delete a sede
    public void deleteSede(int idSede, int tipo) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Sede sede = (Sede) session.load(Sede.class, new Integer(idSede));
            session.delete(sede);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
    }
}
