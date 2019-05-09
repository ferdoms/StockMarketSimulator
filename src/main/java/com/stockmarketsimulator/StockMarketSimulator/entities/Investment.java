/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Inheritance;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.InheritanceType;

/**
 *
 * @author fernandoms
 */

@Entity(name="investment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="investment_type", 
  discriminatorType = DiscriminatorType.STRING)
public abstract class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    int value = 0;
    
    @Column(insertable = false, updatable = false)
    String investment_type;
    
    public int getValue(){
        return this.value;
    }
    public String getType(){
        return this.investment_type;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Investment{" + "id=" + id + ", value=" + value + ", type=" + getType() + '}';
    }
    
    
}
