package com.stockmarketsimulator.StockMarketSimulator.observable;

import com.stockmarketsimulator.StockMarketSimulator.dao.InvestmentDao;
import com.stockmarketsimulator.StockMarketSimulator.dao.TransactionDao;
import com.stockmarketsimulator.StockMarketSimulator.entities.Investment;
import com.stockmarketsimulator.StockMarketSimulator.entities.Share;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernandoms
 */
@Component
public class TransactionPerfomedListener implements EventListener<Integer>{
    @Autowired
    TransactionDao transactionDao;
    @Autowired
    InvestmentDao investmentDao;
    private Integer transactionsPerformed = 0;
    
  
    public void update(String eventType, Integer tp) {
        if((tp%10)==0){
            
            List<Object[]> list = transactionDao.getLowDemandInvestment();
            Iterator iList = list.iterator();
            while(iList.hasNext()){
                Object[] o = (Object[])iList.next();
                Integer index = ((BigInteger)o[0]).intValue();
                Share share = (Share)investmentDao.getById(index);
                ((Share)share).setValue((int)Math.round(((Share)share).getValue()*0.98)); 
                
                investmentDao.update((Investment)share);
            }
                
        }       
    }
}
