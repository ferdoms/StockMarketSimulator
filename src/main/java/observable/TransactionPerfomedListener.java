package observable;

import dao.InvestmentDao;
import dao.TransactionDao;
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
public class TransactionPerfomedListener implements EventListener<Integer>{
    
    private Integer transactionsPerformed = 0;
  
    public void update(String eventType, Integer tp) {
        if((tp%10)==0){
            List<Object[]> list = new TransactionDao().getLowDemandInvestment();
            Iterator iList = list.iterator();
            while(iList.hasNext()){
                Object[] o = (Object[])iList.next();
                Share old = (Share)new InvestmentDao().getById((Integer)o[0]);
                Share share = (Share)new InvestmentDao().getById((Integer)o[0]);
                ((Share)share).setValue((int)Math.round(((Share)share).getValue()*0.98)); 
                
                        System.out.println("Share price Down \n " + old.getCompany().getCompanyName() + " - " + old.getCompany().getId() +
                    "\n Sold " + (old.getAmount() - ((Share)share).getAmount()) +
                    "\n Increase " + old.getValue() + " -> " + share.getValue());
                new InvestmentDao().update(share);
            }
                
        }       
    }
}
