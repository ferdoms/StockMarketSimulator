/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.builders;


import com.stockmarketsimulator.StockMarketSimulator.entities.Investor;
import com.stockmarketsimulator.StockMarketSimulator.entities.Company;
import com.stockmarketsimulator.StockMarketSimulator.entities.Investment;
import java.util.ArrayList;

/**
 *
 * @author jacqu
 */
public interface Broker {
    
// should return any investment with values up to the inserted parameter
    public Investment[] investmentsUpTo(int value);
    // create investments ideally store in arrayList;
    public void createInvestments(ArrayList<Company> companies);
    
    public void performTransaction(Investor investor, Investment investment);
    
    public void recordTransaction(Investor investor, Investment investment);
    
    public class Report{};
    
}
