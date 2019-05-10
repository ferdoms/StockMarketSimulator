/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.dao;

import com.stockmarketsimulator.StockMarketSimulator.entities.Investment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.stockmarketsimulator.StockMarketSimulator.repository.InvestmentRepository;
import org.springframework.stereotype.Service;
/**
 *
 * @author fernandoms
 */
@Service
public class InvestmentDao implements Dao <Investment> {
    
    @Autowired
    InvestmentRepository investments;
    
    @Override
    public void save(Investment investment) {
        investments.save(investment);
    }
    @Override
    public void saveAll(List<Investment> investmentList) {
        investments.saveAll(investmentList);
    }

    @Override
    public Investment getById(int id) {
        Optional<Investment> i = this.investments.findById(new Long(id));
        return i.get();
    }

    @Override
    public List<Investment> getAll() {
        return this.investments.findAll();
    }
    
    

    @Override
    public void update(Investment investment) {
        this.investments.save(investment);
    }

    @Override
    public void delete(int id) {
        Optional<Investment> i = this.investments.findById(new Long(id));
        this.investments.delete(i.get());
    }  
    @Override
    public void deleteAll() {
        this.investments.deleteAll();
    }  
}