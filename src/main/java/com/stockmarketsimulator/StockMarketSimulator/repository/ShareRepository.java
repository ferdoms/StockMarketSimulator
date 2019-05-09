/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.repository;
import com.stockmarketsimulator.StockMarketSimulator.entities.Share;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Joao pedro Haddad Oliveira
 * 
 */
@Repository
public interface ShareRepository extends JpaRepository<Share, Long>{

}
