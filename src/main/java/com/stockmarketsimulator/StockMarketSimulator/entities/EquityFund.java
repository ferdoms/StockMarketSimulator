/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


/**
 *
 * @author fernandoms
 */
@Entity
@DiscriminatorValue("equity_fund")
public class EquityFund extends Investment {
    
//    @Column(name="shares_sold")
    private int soldShareCounter = 0;
    @Column(name="amount")
    private int amount;
    @Column(name="share_price")
    private int sharePrice;
    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    Company company;
    
    public EquityFund(){}
    
    public EquityFund(Share shares){
//        for(Share s:shares){
            this.value = shares.getValue();
//        }
//        this.value = company.getSharePrice();
    }       
    public void setValue(int value){
        this.value = value;
    }
    public Company getCompany(){
        return company;
    }
    public int getAmount(){
        return amount;
    }
    public int getValue(){
        return value;
    }
    
    
}
