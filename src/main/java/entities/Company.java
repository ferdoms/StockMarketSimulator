/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jacqu
 */

@Entity
@Table(name="company")
public class Company {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="company_name")
    private String companyName;
    @Column(name="number_shares")
    private int numberOfShares;
    @Column(name="share_price")
    private int sharePrice;
    @OneToMany(mappedBy="company")
    private List<Share> Share;
    
    
     
    public Company(){
        
    }

    public Company(String companyName, int numberOfShares, int sharePrice) {
        this.companyName = companyName;
        this.numberOfShares = numberOfShares;
        this.sharePrice = sharePrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public int getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(int sharePrice) {
        this.sharePrice = sharePrice;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", companyName=" + companyName + ", numberOfShares=" + numberOfShares + ", sharePrice=" + sharePrice + '}';
    }
    
    

}