/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.builders;

/**
 *
 * @author jacqu
 */
public interface CompanyBuilderInterface {
    
    public void setName(String name);
    public void setNShares(int amount);
    public void setIPOShareValue(int value);
    
}

