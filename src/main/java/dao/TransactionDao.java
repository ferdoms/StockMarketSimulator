/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TransactionRecord;
import util.HibernateUtil;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import entities.Investment;
import entities.Company;
import entities.Share;
import javax.persistence.Tuple;
import javax.persistence.criteria.Join;
import org.hibernate.SQLQuery;

/**
 *
 * @author Joao Pedro H. Oliveira
 */
public class TransactionDao implements Dao<TransactionRecord> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Transaction transaction = null;

    public void save(TransactionRecord t) {
        Session session = sessionFactory.openSession();
        
        try {

            //start a transaction
            transaction = session.beginTransaction();
            //save object 
            session.save(t);
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
    public TransactionRecord getById(int id) {
        Session session = sessionFactory.openSession();
        
        try {
            // start a transaction
            transaction = session.beginTransaction();
            //get transaction record by primary key id
            TransactionRecord t = (TransactionRecord) session.get(TransactionRecord.class, id);
            //commit transaction
            transaction.commit();
            //return transaction records    
            return t;
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
    public List<TransactionRecord> getAll() {
        Session session = sessionFactory.openSession();
        try {

            //start a transaction
            transaction = session.beginTransaction();
            //save object
            CriteriaBuilder builder = session.getCriteriaBuilder();
            //Create CriteriaQuery
            CriteriaQuery<TransactionRecord> criteria = builder.createQuery(TransactionRecord.class);
            //Specify criteria root
            criteria.from(TransactionRecord.class);
            //Execute query
            List<TransactionRecord> transactions = session.createQuery(criteria).getResultList();
            //Return all transactions
            return transactions;

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
    public void update(TransactionRecord t) {
        Session session = sessionFactory.openSession();
        
        try {

            //Start a transaction
            transaction = session.beginTransaction();
            session.update(t);
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
            TransactionRecord t = (TransactionRecord) session.load(TransactionRecord.class, id);
            session.delete(t);
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
    // return a list of companies that has sold 10 shares
    public List<Object[]> getLowDemandInvestment() {
        Session session = sessionFactory.openSession();
        try {

            //start a transaction
            transaction = session.beginTransaction();
            
            SQLQuery query = session.createSQLQuery("select i.id, count(t.id) as totals\n" +
                "from transaction as t\n" +
                "right join investment as i on t.investment_id = i.id\n" +
                "group by i.id\n" +
                "having count(t.id) = 0");
            List<Object[]> rows = query.list();
            return rows;

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
    
    
}