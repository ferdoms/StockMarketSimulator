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
import com.stockmarketsimulator.StockMarketSimulator.representational.CompanyRepresentational;
import com.stockmarketsimulator.StockMarketSimulator.representational.Report;
import com.stockmarketsimulator.StockMarketSimulator.repository.CompanyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stockmarketsimulator.StockMarketSimulator.stockmarketsimulator.ShareBroker;
import com.stockmarketsimulator.StockMarketSimulator.stockmarketsimulator.Simulator;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author fernandoms
 */

@RestController
@RequestMapping(value="/api/report",  produces = "application/json") 
public class ReportController {
    
    @Autowired
    CompanyDao companies;
    
    @Autowired
    Simulator sim;
    
    @Autowired
    ShareBroker broker;
    
    @Autowired
    TransactionDao transactionDao;
    
    @Autowired
    InvestmentDao investmentDao;
    
    @GetMapping() // Finds all stored lecturers in a pageable format
    @ResponseBody
    public Report getReport(){
        return transactionDao.getReport();
    }
    
    @GetMapping("/lowest-capital") // Finds all stored lecturers in a pageable format
    @ResponseBody
    public CompanyRepresentational[] getCompanyLowestCapital(){
        return transactionDao.getCompanyLowestCapital();
    }
    
    @GetMapping("/highest-capital") // Finds all stored lecturers in a pageable format
    @ResponseBody
    public CompanyRepresentational[] getCompanyHighestCapital(){
        return transactionDao.getCompanyHighestCapital();
    }
    
    @GetMapping("/highest-nshare") // Finds all stored lecturers in a pageable format
    public Object[] getInvestorHighestNShare(){
        return transactionDao.getInvestorHighestNShare().toArray();
    }
    
    @GetMapping("/lowest-nshare") // Finds all stored lecturers in a pageable format
    public Object[] getInvestorLowestNShare(){
        return transactionDao.getInvestorLowestNShare().toArray();
    }
    
}