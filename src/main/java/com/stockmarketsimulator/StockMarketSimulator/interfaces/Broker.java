/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Investment;
import entities.Investor;
import entities.Company;
import java.util.ArrayList;

/**
 *
 * @author fernandoms
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
