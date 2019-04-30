/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarketsimulator;

import dao.InvestmentDao;
import dao.TransactionDao;
import entities.Company;
import entities.Investor;
import interfaces.Broker;
import entities.Investment;
import java.util.ArrayList;
import entities.Share;
import entities.TransactionRecord;
import java.util.Iterator;
import java.util.List;
import observable.ShareSoldListener;
import observable.EventManager;
import observable.TransactionPerfomedListener;

/**
 *
 * @author fernandoms
 */
public class ShareBroker implements Broker {
    
    private int transactionsPeformed;
    public EventManager events;
    
    public ShareBroker(){
        this.events = new EventManager("sharesSold", "transactionsPeformed");
        this.events.subscribe("transactionsPeformed", new TransactionPerfomedListener());
    }
    @Override
    public Investment[] investmentsUpTo(int amount){
        // get list of investments
        List<Investment> temp = new InvestmentDao().getAll();
        
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
            new InvestmentDao().save(share);
            sharesSoldListener.addShare(share);
        }
        this.events.subscribe("sharesSold", sharesSoldListener);
    }

    
    public void recordTransaction(Investor investor, Investment investment) {
        TransactionRecord record = new TransactionRecord(investor,investment);
        new TransactionDao().save(record);
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
