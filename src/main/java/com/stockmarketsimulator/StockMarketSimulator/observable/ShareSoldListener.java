package com.stockmarketsimulator.StockMarketSimulator.observable;

import com.stockmarketsimulator.StockMarketSimulator.dao.InvestmentDao;
import com.stockmarketsimulator.StockMarketSimulator.entities.Investment;
import com.stockmarketsimulator.StockMarketSimulator.entities.Share;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernandoms
 */
public class ShareSoldListener implements EventListener<Investment>{
    
    @Autowired
    InvestmentDao investmentDao;
    private List<Investment> shares = new ArrayList<Investment>();
    
    public void addShare(Investment share){
        shares.add(share);
    }
    public void addInvestments(List<Investment> investments){
        shares = investments;
    }

    public void update(String eventType, Investment investment) {
        Share share = (Share)investment;
        share.accountSoldShare();
        
        Share old = null;
         
        for (Investment s:shares){
            if(share.getId()==s.getId()){
                old = (Share)s;
                break;
            }
        }
        if((old.getAmount()-((Share)share).getAmount())%10==0){
            int oldValue = share.getValue();
            share.setValue((int)Math.round(share.getValue()*1.02));
        }
        investmentDao.update((Investment) share);
    }
}
