/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stockmarketsimulator.ShareBroker;
import stockmarketsimulator.Simulator;

/**
 *
 * @author fernandoms
 */

@RestController
@RequestMapping("api/stock-market") // lecturers endpoint
public class StockMarketController {
    
    @GetMapping()
    public void simulate(){
        Simulator sim = new Simulator();
        System.out.println("loading companies");
        sim.loadCompanies(100);
        System.out.println("loading investors");
        sim.loadInvestors(100);
        System.out.println("loading broker");
        
        sim.loadBroker(new ShareBroker());
        System.out.println("Transactions started");
        sim.tradingDay();
    }
}
