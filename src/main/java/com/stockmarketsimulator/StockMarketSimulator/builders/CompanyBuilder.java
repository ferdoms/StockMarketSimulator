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
public class CompanyBuilder implements CompanyBuilderInterface {

    private String name;
    private int nShare;
    private int IPOSharePrice;
    
    public void setName(String name){
        this.name = name;
    }
    

    public Company getObject(){
        return new Company(this.name, this.nShare, this.IPOSharePrice);
    }

    @Override
    public void setNShares(int amount) {
        this.nShare = amount;
    }

    @Override
    public void setIPOShareValue(int value) {
        this.IPOSharePrice = value;
    }
    
}
