/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Investment;
import util.HibernateUtil;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author fernandoms
 */
public class InvestmentDao implements Dao <Investment> {
    
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Transaction transaction = null;

    @Override
    public void save(Investment investment) {
        Session session = sessionFactory.openSession();
        
        try {

            //start a transaction
            transaction = session.beginTransaction();
            //save object
            session.save(investment);
            //commit transaction
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
    public Investment getById(int id) {
        Session session = sessionFactory.openSession();
        
        try {
            //Start a transaction
            transaction = session.beginTransaction();
            //Get investment by primary key id
            Investment investment = (Investment) session.get(Investment.class, id);
            //Commit transaction
            transaction.commit();
            //Return investment 
            return investment;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Investment> getAll() {
        Session session = sessionFactory.openSession();
        
        try {

            //Start a transaction
            transaction = session.beginTransaction();
            //Save object
            CriteriaBuilder builder = session.getCriteriaBuilder();
            //Create CriteriaQuery
            CriteriaQuery<Investment> criteria = builder.createQuery(Investment.class);
            //Specify criteria root
            criteria.from(Investment.class);
            //Execute query
            List<Investment> investments = session.createQuery(criteria).getResultList();
            //Return all investments
            return investments;
            
            

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }
    
    

    @Override
    public void update(Investment investment) {
        Session session = sessionFactory.openSession();
        
        try {

            //Start a transaction
            transaction = session.beginTransaction();
            session.update(investment);
            transaction.commit();
                        
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
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
            Investment investment = (Investment) session.load(Investment.class, id);
            session.delete(investment);
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