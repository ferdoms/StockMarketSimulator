
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.dao;

import com.stockmarketsimulator.StockMarketSimulator.entities.TransactionRecord;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.stockmarketsimulator.StockMarketSimulator.repository.TransactionRepository;
/**
 *
 * @author Joao Pedro H. Oliveira
 */
public class TransactionDao implements Dao<TransactionRecord> {
    
    @Autowired
    TransactionRepository transactions;
    
    @Override
    public void save(TransactionRecord tr) {
        transactions.save(tr);
    }
    

    @Override
    public TransactionRecord getById(int id) {
        Optional<TransactionRecord> tr = this.transactions.findById(new Long(id));
        return tr.get();
    }

    @Override
    public List<TransactionRecord> getAll() {
        return this.transactions.findAll();
    }
    
    

    @Override
    public void update(TransactionRecord tr) {
        this.transactions.save(tr);
    }

    @Override
    public void delete(int id) {
        Optional<TransactionRecord> tr = this.transactions.findById(new Long(id));
        this.transactions.delete(tr.get());
    }  
}

