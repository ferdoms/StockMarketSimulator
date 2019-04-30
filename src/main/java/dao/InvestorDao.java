/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Investor;
import util.HibernateUtil;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author jacqu
 */
public class InvestorDao implements Dao <Investor>{
    
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Transaction transaction = null;
    
   
    @Override
    public void save (Investor i) {
        Session session = sessionFactory.openSession();
        
        try {

            //Start a transaction
            transaction = session.beginTransaction();
            //Save object investor
            session.save(i);
            //Commit transaction
            transaction.commit();
                    
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Investor getById(int id) {
        Session session = sessionFactory.openSession();
        
        try {
            //Start a transaction
            transaction = session.beginTransaction();
            //Get investor by primary key id
            Investor  i = (Investor) session.get(Investor.class, id);
            //Commit transaction
            transaction.commit();
            //Return company
            return i;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }   

    @Override
    public List<Investor> getAll() {
        Session session = sessionFactory.openSession();
        
        try {

            //Start a transaction
            transaction = session.beginTransaction();
            //Save object
            CriteriaBuilder builder = session.getCriteriaBuilder();
            //Create CriteriaQuery
            CriteriaQuery<Investor> criteria = builder.createQuery(Investor.class);
            //Specify criteria root
            criteria.from(Investor.class);
            //Execute query
            List<Investor> investors = session.createQuery(criteria).getResultList();
            //Return all investors
            return investors;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(Investor i) {        
        Session session = sessionFactory.openSession();
        
        try {

            //Start a transaction
            transaction = session.beginTransaction();
            session.update(i);
            transaction.commit();
                        
       } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        
        try {

            //Start a transaction
            transaction = session.beginTransaction();
            Investor investor = (Investor) session.load(Investor.class, id);
            session.delete(investor);
            transaction.commit();
                        
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    } 
}
