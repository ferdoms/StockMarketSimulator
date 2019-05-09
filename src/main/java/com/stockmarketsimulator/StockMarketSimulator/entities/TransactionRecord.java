/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Joao Pedro H. Oliveira
 */
@Entity
@Table(name = "transaction")
public class TransactionRecord {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "investor_id", referencedColumnName = "id")
    private Investor investor;
    @ManyToOne
    @JoinColumn(name = "investment_id", referencedColumnName = "id")
    private Investment investment;
    @Column(name="amount")
    private int amount;

    public TransactionRecord(Investor buyer, Investment investment) {
        this.investor = buyer;
        this.investment = investment;
        this.amount = investment.getValue();
    }


    
    public Investor getInvestor(){
        return this.investor;
    }
    public Investment getInvestment(){
        return this.investment;
    }

}
