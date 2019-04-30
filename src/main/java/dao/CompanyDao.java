/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Company;
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
public class CompanyDao implements Dao<Company> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Transaction transaction = null;
    
    @Override
    public void save(Company c) {
        Session session = sessionFactory.openSession();
        
        try {

            //Start a transaction
            transaction = session.beginTransaction();
            //Save object
            session.save(c);
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
    public Company getById(int id) {
        Session session = sessionFactory.openSession();
        
        try {
            //Start a transaction
            transaction = session.beginTransaction();
            //Get company by primary key id
            Company c = (Company) session.get(Company.class, id);
            //Commit transaction
            transaction.commit();
            //Return company
            return c;
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
    public List<Company> getAll() {
        Session session = sessionFactory.openSession();
        
        try {

            //Start a transaction
            transaction = session.beginTransaction();
            //Save object
            CriteriaBuilder builder = session.getCriteriaBuilder();
            //Create CriteriaQuery
            CriteriaQuery<Company> criteria = builder.createQuery(Company.class);
            //Specify criteria root
            criteria.from(Company.class);
            //Execute query
            List<Company> companies = session.createQuery(criteria).getResultList();
            //Return all companies
            return companies;

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public void update(Company c) {
        Session session = sessionFactory.openSession();
        
        try {

            //Start a transaction
            transaction = session.beginTransaction();
            session.update(c);
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
            Company company = (Company) session.load(Company.class, id);
            session.delete(company);
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
