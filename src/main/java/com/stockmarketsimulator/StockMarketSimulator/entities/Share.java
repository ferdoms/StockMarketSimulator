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
@DiscriminatorValue("share")
public class Share extends Investment {
    
//    @Column(name="shares_sold")
    private int soldShareCounter = 0;
    @Column(name="amount")
    private int amount;
    @Column(name="share_price")
    private int sharePrice;
    @ManyToOne
    @JoinColumn(name="company_id", nullable=false)
    Company company;
    
    public Share(){}
    
    public Share(Company company){
        this.value = company.getSharePrice();
        this.company = company;
        this.amount = company.getNumberOfShares();
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
    public void accountSoldShare(){
        this.amount--;
    }
    
}
