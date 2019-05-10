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
public class Report {
    private CompanyRepresentational[] lowestCapital;
    private CompanyRepresentational[] highestCapital;
    private InvestorRepresentational[] lowestNShares;
    private InvestorRepresentational[] highestNShares;
    private InvestorRepresentational[] leastCompanies;
    private InvestorRepresentational[] mostCompanies;
    
    public Report(
        CompanyRepresentational[] lowestCapital,
        CompanyRepresentational[] highestCapital,
        InvestorRepresentational[] lowestNShares,
        InvestorRepresentational[] highestNShares,
        InvestorRepresentational[] leastCompanies,
        InvestorRepresentational[] mostCompanies){
        this.lowestCapital = lowestCapital;
        this.highestCapital = highestCapital;
        this.lowestNShares = lowestNShares;
        this.highestNShares = highestNShares;
        this.leastCompanies = leastCompanies;
        this.mostCompanies = mostCompanies;
    }

    public CompanyRepresentational[] getLowestCapital() {
        return lowestCapital;
    }

    public CompanyRepresentational[] getHighestCapital() {
        return highestCapital;
    }

    public InvestorRepresentational[] getLowestNShares() {
        return lowestNShares;
    }

    public InvestorRepresentational[] getHighestNShares() {
        return highestNShares;
    }

    public InvestorRepresentational[] getLeastCompanies() {
        return leastCompanies;
    }

    public InvestorRepresentational[] getMostCompanies() {
        return mostCompanies;
    }
    
    
}
