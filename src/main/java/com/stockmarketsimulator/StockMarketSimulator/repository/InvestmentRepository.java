/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.repository;

import com.stockmarketsimulator.StockMarketSimulator.entities.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author jacqu
 */

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    
}
