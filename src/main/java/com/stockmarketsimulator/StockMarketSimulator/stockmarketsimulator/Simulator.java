/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarketsimulator;

import builders.CompanyBuilder;
import builders.Director;
import builders.InvestorBuilder;
import dao.CompanyDao;
import dao.InvestorDao;
import entities.Company;
import entities.Investor;
import interfaces.Broker;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Joao Pedro H. Oliveira
 */
public class Simulator {
    //creating arraylists for company and investors
    public ArrayList<Company> companies = new ArrayList<Company>();
    public ArrayList<Investor> investors = new ArrayList<Investor>();
    Broker broker = null;
    
    
    public void loadCompanies(int amount){
        // instantiate company's builder
        CompanyBuilder comBuilder = new CompanyBuilder();
        // instantiate director's object
        Director director = new Director();
        
        //loop over elements
        for(int n=1; n<=amount; n++){
            director.constructCompany(comBuilder);
            Company newCompany = comBuilder.getObject();
           new CompanyDao().save(newCompany);
           companies.add(newCompany);
        }
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
           new InvestorDao().save(newInvestor);
           investors.add(newInvestor);
        }
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
        }
    }

}
