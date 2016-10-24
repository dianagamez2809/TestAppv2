/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diana.dao;

import com.diana.model.Ciudad;
import com.diana.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author diana
 */
public class CiudadDAO {
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
}
