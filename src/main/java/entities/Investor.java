/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dao.InvestmentDao;
import dao.InvestorDao;
import interfaces.Broker;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jacqu
 */

@Entity
@Table(name="investor")
public class Investor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="budget")
    private int budget;    
     
    public Investor(){
        
    }

    public Investor(String firstName, String lastName, int budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
    
    public void buyInvestment(Broker broker){
        Investment[] investments = broker.investmentsUpTo(this.budget);
        int n = new Random().nextInt(investments.length);
        Investment investment = investments[n];
        broker.performTransaction(this, investment);   
    }
    public void confirmAquisition(Investment investment){
        int temp = this. getBudget();
        temp = temp -investment.getValue();
        this.setBudget(temp);
        new InvestorDao().update(this);
    }

    @Override
    public String toString() {
        return "Investor{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", budget=" + budget + '}';
    }
    
    
    
}
