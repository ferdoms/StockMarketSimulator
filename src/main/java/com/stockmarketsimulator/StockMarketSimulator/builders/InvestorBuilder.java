/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.builders;

import com.stockmarketsimulator.StockMarketSimulator.entities.Investor;
/**
 *
 * @author fernandoms
 */

public class InvestorBuilder implements InvestorBuilderInterface {
    
    private String firtName;
    private String lastName;
    private int budget;
    
    
    public void setFirstName(String firstName){
        this.firtName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setBudget(int budget){
        this.budget = budget;
    }
    public Investor getObject(){
        return new Investor(this.firtName, this.lastName, this.budget);
    }
    
}
