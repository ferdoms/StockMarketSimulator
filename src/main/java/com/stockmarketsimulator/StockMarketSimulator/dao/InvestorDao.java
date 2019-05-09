/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.dao;

import com.stockmarketsimulator.StockMarketSimulator.entities.Investor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.stockmarketsimulator.StockMarketSimulator.repository.InvestorRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joao Pedro Haddad Oliveira
 */
@Service
public class InvestorDao implements Dao <Investor>{
    
    @Autowired
    InvestorRepository investors;
    
   
    @Override
    public void save (Investor i) {
        investors.save(i);
    }

    @Override
    public Investor getById(int id) {
        Optional<Investor> i = this.investors.findById(new Long(id));
        return i.get();
    }   

    @Override
    public List<Investor> getAll() {
        return this.investors.findAll();
    }

    @Override
    public void update(Investor i) {        
        this.investors.save(i);
    }

    @Override
    public void delete(int id) {
        Optional<Investor> i = this.investors.findById(new Long(id));
        this.investors.delete(i.get());
    }
}
