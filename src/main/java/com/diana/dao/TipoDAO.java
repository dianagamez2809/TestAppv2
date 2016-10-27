package com.diana.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
