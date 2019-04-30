package observable;

import dao.InvestmentDao;
import entities.Investment;
import entities.Share;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import observable.EventListener;

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
    
    private List<Investment> shares = new ArrayList<Investment>();
    
    public void addShare(Investment share){
        shares.add(share);
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
            share.setValue(share.getValue()*2);
            System.out.println("Share price Up \n " + old.getCompany().getCompanyName() + " - " + old.getCompany().getId() +
                    "\n Sold " + (old.getAmount() - ((Share)share).getAmount()) +
                    "\n Increase " + oldValue + " -> " + share.getValue());
        }
//        System.out.println("Share sold \n " + old.getCompany().getCompanyName() + " -> " + (old.getAmount() - ((Share)share).getAmount()));
        new InvestmentDao().update((Investment) share);
    }
}
