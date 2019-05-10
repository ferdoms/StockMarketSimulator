/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.representational;

/**
 *
 * @author fernandoms
 */
public class CompanyRepresentational {
    String name;
    Integer value;
    public CompanyRepresentational(String n, Integer v){
        this.name = n;
        this.value = v;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }
    
}
