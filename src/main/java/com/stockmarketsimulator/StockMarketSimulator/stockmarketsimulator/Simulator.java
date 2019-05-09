/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.stockmarketsimulator;

import com.stockmarketsimulator.StockMarketSimulator.builders.CompanyBuilder;
import com.stockmarketsimulator.StockMarketSimulator.builders.Director;
import com.stockmarketsimulator.StockMarketSimulator.builders.InvestorBuilder;
import com.stockmarketsimulator.StockMarketSimulator.dao.CompanyDao;
import com.stockmarketsimulator.StockMarketSimulator.dao.InvestorDao;
import com.stockmarketsimulator.StockMarketSimulator.entities.Company;
import com.stockmarketsimulator.StockMarketSimulator.entities.Investor;
import com.stockmarketsimulator.StockMarketSimulator.builders.Broker;
import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Joao Pedro H. Oliveira
 */
@Component
public class Simulator {
    //creating arraylists for company and investors
    public ArrayList<Company> companies = new ArrayList<Company>();
    public ArrayList<Investor> investors = new ArrayList<Investor>();
    Broker broker = null;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    InvestorDao investorDao;
    
    public void loadCompanies(int amount){
        // instantiate company's builder
        CompanyBuilder comBuilder = new CompanyBuilder();
        // instantiate director's object
        Director director = new Director();
        
        //loop over elements
        for(int n=1; n<=amount; n++){
           director.constructCompany(comBuilder);
           Company newCompany = comBuilder.getObject();
           companies.add(newCompany);
        }
        companyDao.saveAll(companies);
    }
    
    public void loadInvestors(int amount){
         // instantiate investor's builder
        InvestorBuilder invBuilder = new InvestorBuilder();
        // instantiate director's object
        Director director = new Director();
        //loop over elements
        for(int n=1; n<=amount; n++){
            director.constructInvestor(invBuilder);
            Investor newInvestor = invBuilder.getObject();
           investors.add(newInvestor);
        }
        
           investorDao.saveAll(investors);
    }
    public void loadBroker(Broker broker){
        if(broker instanceof ShareBroker){
            this.broker = broker;
        }
        this.broker.createInvestments(companies);
        
    }
    
    public void tradingDay(){
        Iterator investorsIte = investors.iterator();
        
        // stores the top budget investor
        Investor topBdgInvestor = null;
        
        
        while(investorsIte.hasNext()){
//           System.out.println("stockmarketsimulator.Simulator.tradingDay()");
            Investor temp = (Investor)investorsIte.next();
            
            // check if investor has enough budget to buy an investment
            if(broker.investmentsUpTo(temp.getBudget()).length>0){
                temp.buyInvestment(broker);
            }
            // if temp investor has more budget than the topBdgInvestor replace
            if((topBdgInvestor == null)||(temp.getBudget()>topBdgInvestor.getBudget())){
                topBdgInvestor = temp;
            }
        }
        // if there are still shares and buyers with budget, keep trading.
        if((broker.investmentsUpTo(topBdgInvestor.getBudget()).length>0)){
            this.tradingDay();
        }else{
            broker.closeMarket();
            investorDao.saveAll(investors);
        }
    }

}
