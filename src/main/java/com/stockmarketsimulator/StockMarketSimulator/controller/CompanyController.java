/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.controller;

import com.stockmarketsimulator.StockMarketSimulator.builders.CompanyBuilder;
import com.stockmarketsimulator.StockMarketSimulator.builders.Director;
import com.stockmarketsimulator.StockMarketSimulator.dao.CompanyDao;
import com.stockmarketsimulator.StockMarketSimulator.entities.Company;
import com.stockmarketsimulator.StockMarketSimulator.repository.CompanyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stockmarketsimulator.StockMarketSimulator.stockmarketsimulator.ShareBroker;
import com.stockmarketsimulator.StockMarketSimulator.stockmarketsimulator.Simulator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fernandoms
 */

@RestController
@RequestMapping("/company") 
public class CompanyController {
    
    @Autowired
    CompanyDao companies;
    
    @Autowired
    Simulator sim;
    
    @Autowired
    ShareBroker broker;
    
    @GetMapping("/teste") // Finds all stored lecturers in a pageable format
    public String teste(){
//        
//        CompanyBuilder comBuilder = new CompanyBuilder();
//        // instantiate director's object
//        Director director = new Director();
//        
////        loop over elements
//        for(int n=1; n<=10; n++){
//            director.constructCompany(comBuilder);
//            Company newCompany = comBuilder.getObject();
//            
//                
//         companies.save(newCompany);
////           new CompanyDao().save(newCompany);
//        }
           
        
        
        
        
        
        
//        Simulator sim = new Simulator();
        System.out.println("loading companies");
        sim.loadCompanies(10);
        System.out.println("loading investors");
        sim.loadInvestors(100);
        System.out.println("loading broker");
        
        sim.loadBroker(broker);
        System.out.println("Transactions started");
        sim.tradingDay();
        return "foi";
//        return "teste";
    }
    
}