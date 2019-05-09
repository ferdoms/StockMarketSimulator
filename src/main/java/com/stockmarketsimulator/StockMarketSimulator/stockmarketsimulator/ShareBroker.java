/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.stockmarketsimulator;

import com.stockmarketsimulator.StockMarketSimulator.dao.InvestmentDao;
import com.stockmarketsimulator.StockMarketSimulator.dao.TransactionDao;
import com.stockmarketsimulator.StockMarketSimulator.entities.Company;
import com.stockmarketsimulator.StockMarketSimulator.entities.Investor;
import com.stockmarketsimulator.StockMarketSimulator.builders.Broker;
import com.stockmarketsimulator.StockMarketSimulator.entities.Investment;
import java.util.ArrayList;
import com.stockmarketsimulator.StockMarketSimulator.entities.Share;
import com.stockmarketsimulator.StockMarketSimulator.entities.TransactionRecord;
import java.util.Iterator;
import java.util.List;
import com.stockmarketsimulator.StockMarketSimulator.observable.ShareSoldListener;
import com.stockmarketsimulator.StockMarketSimulator.observable.EventManager;
import com.stockmarketsimulator.StockMarketSimulator.observable.TransactionPerfomedListener;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fernandoms
 */
public class ShareBroker implements Broker {
    
    private int transactionsPeformed;
    public EventManager events;
    @Autowired
    InvestmentDao investorDao;
    @Autowired
    TransactionDao transactionDao;
    
    public ShareBroker(){
        this.events = new EventManager("sharesSold", "transactionsPeformed");
        this.events.subscribe("transactionsPeformed", new TransactionPerfomedListener());
    }
    @Override
    public Investment[] investmentsUpTo(int amount){
        // get list of investments
        List<Investment> temp = investorDao.getAll();
        
        // filter investments that has no shares available
        temp.removeIf(i-> (((Share)i).getAmount() < 1));
        
        // filter investments up to @param amount
        temp.removeIf(i-> (i.getValue() > amount));
        
        Object[] tempArray = temp.toArray();
        Investment[] tempArrayInvest = new Investment[tempArray.length];
            for (int i=0;i<tempArray.length;i++){
                tempArrayInvest[i] = (Investment)tempArray[i];
            }
        return tempArrayInvest;
    }
    @Override
    public void createInvestments(ArrayList<Company> companies) {
        ShareSoldListener sharesSoldListener = new ShareSoldListener();
        Iterator comps = companies.iterator();
        while(comps.hasNext()){
            Company company = (Company)comps.next();
            Investment share = new Share(company);
            investorDao.save(share);
            sharesSoldListener.addShare(share);
        }
        this.events.subscribe("sharesSold", sharesSoldListener);
    }

    
    public void recordTransaction(Investor investor, Investment investment) {
        TransactionRecord record = new TransactionRecord(investor,investment);
        transactionDao.save(record);
    }
    public void performTransaction(Investor investor, Investment investment ){
        try{
            investor.confirmAquisition(investment);
            this.recordTransaction(investor, investment);
            transactionsPeformed++;
            this.events.notify("sharesSold", investment);
            this.events.notify("transactionsPeformed", transactionsPeformed);
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
