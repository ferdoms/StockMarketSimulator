/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.dao;

import com.stockmarketsimulator.StockMarketSimulator.entities.Company;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.stockmarketsimulator.StockMarketSimulator.repository.CompanyRepository;
import org.springframework.stereotype.Service;


/**
 *
 * @author jacqu
 */

@Service
public class CompanyDao implements Dao<Company> {

    @Autowired
    CompanyRepository companies;
    
    @Override
    public void save(Company c) {
        companies.save(c);
    }
    
    @Override
    public void saveAll(List<Company> companyList) {
        companies.saveAll(companyList);
    }

    @Override
    public Company getById(int id) {
        Optional<Company>  c = this.companies.findById(new Long(id));
        return c.get();
    }

    @Override
    public List<Company> getAll() {
        return this.companies.findAll();
    }

    @Override
    public void update(Company c) {
        this.companies.save(c);
    }

    @Override
    public void delete(int id) {
        Optional<Company>  c = this.companies.findById(new Long(id));
        this.companies.delete(c.get());
    } 
}
