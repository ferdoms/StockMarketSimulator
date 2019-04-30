/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import java.util.Random;
import entities.Company;

/**
 *
 * @author fernandoms
 */
public class CompanyBuilder {

    private String name;
    private int nShare;
    private int IPOSharePrice;
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setNShare(int amount){
        this.nShare = amount;
    }
    public void setIPOShareValue(int value){
        this.IPOSharePrice = value;
    }
    public Company getObject(){
        return new Company(this.name, this.nShare, this.IPOSharePrice);
    }
    
}
