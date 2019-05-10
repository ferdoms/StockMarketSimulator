
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.dao;

import com.stockmarketsimulator.StockMarketSimulator.entities.TransactionRecord;
import com.stockmarketsimulator.StockMarketSimulator.representational.CompanyRepresentational;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.stockmarketsimulator.StockMarketSimulator.repository.TransactionRepository;
import com.stockmarketsimulator.StockMarketSimulator.representational.InvestorRepresentational;
import com.stockmarketsimulator.StockMarketSimulator.representational.Report;
import java.math.BigInteger;
import java.util.Iterator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
/**
 *
 * @author Joao Pedro H. Oliveira
 */
@Service
public class TransactionDao implements Dao<TransactionRecord> {
    
    @Autowired
    TransactionRepository transactions;
    
    @Override
    public void save(TransactionRecord tr) {
        transactions.save(tr);
    }
    @Override
    public void saveAll(List<TransactionRecord> transactionList) {
        transactions.saveAll(transactionList);
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
    
    public List<Object[]> getLowDemandInvestment(){
        List<Object[]> list = transactions.getLowDemandInvestment();
        return list;
    }
    public CompanyRepresentational[] getCompanyLowestCapital(){
        List<Object[]> list = transactions.getCompanyLowestCapital();
        Iterator iList = list.iterator();
        CompanyRepresentational[] result = new CompanyRepresentational[list.size()];
        int index = 0;
        while(iList.hasNext()){
           Object[] item = (Object[])iList.next();
           result[index] = new CompanyRepresentational((String)item[0],(Integer)item[1]);
           index++;
        }
        return result;
    }
    public CompanyRepresentational[] getCompanyHighestCapital(){
        List<Object[]> list = transactions.getCompanyHighestCapital();
        Iterator iList = list.iterator();
        CompanyRepresentational[] result = new CompanyRepresentational[list.size()];
        int index = 0;
        while(iList.hasNext()){
           Object[] item = (Object[])iList.next();
           result[index] = new CompanyRepresentational((String)item[0],(Integer)item[1]);
           index++;
        }
        return result;
    }
    public List<Object[]> getInvestorHighestNShare(){
        List<Object[]> list = transactions.getInvestorHighestNShare();
        return list;
    }
    public List<Object[]> getInvestorLowestNShare(){
        List<Object[]> list = transactions.getInvestorLowestNShare();
        return list;
    }
    @Override
    public void deleteAll() {
        this.transactions.deleteAll();
    }
    public Report getReport(){
        List<Object[]> list = transactions.getCompanyLowestCapital();
        Iterator iList = list.iterator();
        CompanyRepresentational[] lowestCapital = new CompanyRepresentational[list.size()];
        int index = 0;
        while(iList.hasNext()){
           Object[] item = (Object[])iList.next();
           lowestCapital[index] = new CompanyRepresentational((String)item[0],(Integer)item[1]);
           index++;
        }
        list = transactions.getCompanyHighestCapital();
        iList = list.iterator();
        CompanyRepresentational[] higestCapital = new CompanyRepresentational[list.size()];
        index = 0;
        while(iList.hasNext()){
           Object[] item = (Object[])iList.next();
           higestCapital[index] = new CompanyRepresentational((String)item[0],(Integer)item[1]);
           index++;
        }
        list = transactions.getInvestorLowestNShare();
        iList = list.iterator();
        InvestorRepresentational[] lowestNShares = new InvestorRepresentational[list.size()];
        index = 0;
        while(iList.hasNext()){
           Object[] item = (Object[])iList.next();
           lowestNShares[index] = new InvestorRepresentational((String)item[0],(Integer)item[1]);
           index++;
        }
        list = transactions.getCompanyHighestCapital();
        iList = list.iterator();
        InvestorRepresentational[] highestNShares = new InvestorRepresentational[list.size()];
        index = 0;
        while(iList.hasNext()){
           Object[] item = (Object[])iList.next();
           highestNShares[index] = new InvestorRepresentational((String)item[0],(Integer)item[1]);
           index++;
        }
        list = transactions.getInvestorLeastCompanies();
        iList = list.iterator();
        InvestorRepresentational[] leastCompanies = new InvestorRepresentational[list.size()];
        index = 0;
        while(iList.hasNext()){
           Object[] item = (Object[])iList.next();
           leastCompanies[index] = new InvestorRepresentational((String)item[0],((BigInteger)item[1]).intValue());
           index++;
        }
        list = transactions.getInvestorMostCompanies();
        iList = list.iterator();
        InvestorRepresentational[] mostCompanies = new InvestorRepresentational[list.size()];
        index = 0;
        while(iList.hasNext()){
           Object[] item = (Object[])iList.next();
           mostCompanies[index] = new InvestorRepresentational((String)item[0],((BigInteger)item[1]).intValue());
           index++;
        }
        return new Report(lowestCapital, higestCapital, lowestNShares,highestNShares, leastCompanies, mostCompanies);
    }
}

