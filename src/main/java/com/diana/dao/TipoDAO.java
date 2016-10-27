package com.diana.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.diana.model.Ciudad;
import com.diana.model.Sede;
import com.diana.model.Tipo;
import com.diana.util.HibernateUtil;

public class TipoDAO {
	// Function to get a tipo according to the id provided.
    public Tipo getTipo(int idTipo) {
    	Tipo tipo = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Tipo where id = :idTipo";
            Query query = session.createQuery(queryString);
            query.setInteger("idTipo", idTipo);
            tipo = (Tipo) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return tipo;
    }
    
 // Function to get the list of tipos
 	public List<Tipo> getTipos( ){
 		//Open a session of hibernate
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx = null;
       List<Tipo> tipos = new ArrayList<Tipo>();
       try{
          tx = session.beginTransaction();
          // Query from  table 'Tipo'
          tipos = session.createQuery("FROM Tipo").list();
          for (Iterator iterator = 
                  tipos.iterator(); iterator.hasNext();){
 			  Tipo tipo = (Tipo) iterator.next(); 
 		 }
          
          tx.commit();
       }catch (HibernateException e) {
          if (tx!=null) tx.rollback();
          e.printStackTrace(); 
       }finally {
     	 //session.flush();
          session.close(); 
       }
       return tipos;
    }
}
