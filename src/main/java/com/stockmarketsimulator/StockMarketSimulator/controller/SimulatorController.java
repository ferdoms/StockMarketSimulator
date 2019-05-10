/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.controller;

import com.stockmarketsimulator.StockMarketSimulator.builders.CompanyBuilder;
import com.stockmarketsimulator.StockMarketSimulator.builders.Director;
import com.stockmarketsimulator.StockMarketSimulator.dao.CompanyDao;
import com.stockmarketsimulator.StockMarketSimulator.dao.InvestmentDao;
import com.stockmarketsimulator.StockMarketSimulator.dao.TransactionDao;
import com.stockmarketsimulator.StockMarketSimulator.entities.Company;
import com.stockmarketsimulator.StockMarketSimulator.entities.Investment;
import com.stockmarketsimulator.StockMarketSimulator.entities.Share;
import com.stockmarketsimulator.StockMarketSimulator.repository.CompanyRepository;
import com.stockmarketsimulator.StockMarketSimulator.representational.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stockmarketsimulator.StockMarketSimulator.stockmarketsimulator.ShareBroker;
import com.stockmarketsimulator.StockMarketSimulator.stockmarketsimulator.Simulator;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fernandoms
 */

@RestController
@RequestMapping("/api/simulator") 
public class SimulatorController {
    
//    @Autowired
//    CompanyDao companies;
//    
    @Autowired
    Simulator sim;
//    
    @Autowired
    ShareBroker broker;
//    
//    @Autowired
//    TransactionDao transactionDao;
//    
//    @Autowired
//    InvestmentDao investmentDao;
    
    @GetMapping() // Finds all stored lecturers in a pageable format
    public Response simulate(){

        System.out.println("loading companies");
        sim.loadCompanies(100);
        System.out.println("loading investors");
        sim.loadInvestors(100);
        System.out.println("loading broker");
        
        sim.loadBroker(broker);
        System.out.println("Transactions started");
        sim.tradingDay();
        return new Response("Ok");
    }

}