/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarketsimulator;

import entities.Investor;
import interfaces.Broker;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author fernandoms
 */
public class TradingRound implements Runnable {
    private ArrayList<Investor> investors = new ArrayList<Investor>();
    private Broker broker = null;
    
    public TradingRound(ArrayList<Investor> investors, Broker broker){
        this.broker = broker;
        this.investors = investors;
    }
    public void execute(){
        System.out.println("round");
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
//            if((topBdgInvestor == null)||(temp.getBudget()>topBdgInvestor.getBudget())){
//                topBdgInvestor = temp;
//            }
        }
    }
    public void run(){
        this.execute();
    }
    
}
