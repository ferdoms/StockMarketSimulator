/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.repository;

import com.stockmarketsimulator.StockMarketSimulator.entities.TransactionRecord;
import com.stockmarketsimulator.StockMarketSimulator.representational.CompanyRepresentational;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jacqu
 */
@Repository
public interface TransactionRepository extends JpaRepository<TransactionRecord, Long> {
    
    @Query(
            value="select i.id, count(t.id) as totals\n" +
                    "from transaction as t\n" +
                    "right join investment as i on t.investment_id = i.id\n" +
                    "group by i.id\n" +
                    "having count(t.id) = 0",
            nativeQuery = true
    )
    List<Object[]> getLowDemandInvestment();
    
    @Query(
            value="SELECT company_name, value\n" +
                    "FROM company \n" +
                    "INNER JOIN investment ON investment.company_id = company.id \n" +
                    "WHERE value = (SELECT MIN(value) \n" +
                    "FROM investment);",
            nativeQuery = true
    )
    List<Object[]> getCompanyLowestCapital();
    
    
    @Query(
            value="SELECT company_name, value\n" +
                    "FROM company \n" +
                    "INNER JOIN investment ON investment.company_id = company.id \n" +
                    "WHERE value = (SELECT MAX(value) \n" +
                    "FROM investment);",
            nativeQuery = true
    )
    List<Object[]> getCompanyHighestCapital();
    
    
    @Query(
            value="SELECT CONCAT(first_name, \" \" ,last_name) AS investor_name, investor.id, COUNT(investor_id) AS nshares\n" +
                    "FROM investor \n" +
                    "INNER JOIN transaction ON investor.id = transaction.investor_id \n" +
                    "GROUP BY id\n" +
                    "having COUNT(investor_id) = (SELECT COUNT(investor_id) AS nshares\n" +
                    "FROM investor \n" +
                    "INNER JOIN transaction ON investor.id = transaction.investor_id \n" +
                    "GROUP BY investor.id\n" +
                    "ORDER by nshares desc\n" +
                    "limit 1);",
            nativeQuery = true
    )
    List<Object[]> getInvestorLowestNShare();
    
    @Query(
            value="SELECT CONCAT(first_name, \" \" ,last_name) AS investor_name, investor.id, COUNT(investor_id) AS nshares\n" +
                    "FROM investor \n" +
                    "INNER JOIN transaction ON investor.id = transaction.investor_id \n" +
                    "GROUP BY id\n" +
                    "having COUNT(investor_id) = (SELECT COUNT(investor_id) AS nshares\n" +
                    "FROM investor \n" +
                    "INNER JOIN transaction ON investor.id = transaction.investor_id \n" +
                    "GROUP BY investor.id\n" +
                    "ORDER by nshares asc\n" +
                    "limit 1);",
            nativeQuery = true
    )
    List<Object[]> getInvestorHighestNShare();
    
    @Query(
            value="select investor_name, COUNT(investment_id) as frequency\n" +
                    "from (\n" +
                    "SELECT CONCAT(first_name, \" \" ,last_name) AS investor_name, investment_id, investor_id \n" +
                    "from transaction\n" +
                    "INNER JOIN investor ON investor.id = transaction.investor_id\n" +
                    "GROUP BY investor_id, investment_id\n" +
                    ") as transactionsShare\n" +
                    "GROUP BY investor_name, investor_id\n" +
                    "having COUNT(investment_id) = (\n" +
                    "select COUNT(investment_id) as frequency\n" +
                    "from (\n" +
                    "SELECT CONCAT(first_name, \" \" ,last_name) AS investor_name, investment_id, investor_id\n" +
                    "from transaction\n" +
                    "INNER JOIN investor ON investor.id = transaction.investor_id\n" +
                    "GROUP BY investor_id, investment_id\n" +
                    ") as transactionsShare\n" +
                    "GROUP BY investor_name, investor_id\n" +
                    "order by frequency asc\n" +
                    "limit 1\n" +
                    ");",
            nativeQuery = true
    )
    List<Object[]> getInvestorLeastCompanies();
    
    @Query(
            value="select investor_name, COUNT(investment_id) as frequency\n" +
                    "from (\n" +
                    "SELECT CONCAT(first_name, \" \" ,last_name) AS investor_name, investment_id, investor_id \n" +
                    "from transaction\n" +
                    "INNER JOIN investor ON investor.id = transaction.investor_id\n" +
                    "GROUP BY investor_id, investment_id\n" +
                    ") as transactionsShare\n" +
                    "GROUP BY investor_name, investor_id\n" +
                    "having COUNT(investment_id) = (\n" +
                    "select COUNT(investment_id) as frequency\n" +
                    "from (\n" +
                    "SELECT CONCAT(first_name, \" \" ,last_name) AS investor_name, investment_id, investor_id\n" +
                    "from transaction\n" +
                    "INNER JOIN investor ON investor.id = transaction.investor_id\n" +
                    "GROUP BY investor_id, investment_id\n" +
                    ") as transactionsShare\n" +
                    "GROUP BY investor_name, investor_id\n" +
                    "order by frequency desc\n" +
                    "limit 1\n" +
                    ");",
            nativeQuery = true
    )
    List<Object[]> getInvestorMostCompanies();
}
