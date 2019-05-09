package com.stockmarketsimulator.StockMarketSimulator;

import com.stockmarketsimulator.StockMarketSimulator.builders.CompanyBuilder;
import com.stockmarketsimulator.StockMarketSimulator.builders.Director;
import com.stockmarketsimulator.StockMarketSimulator.dao.CompanyDao;
import com.stockmarketsimulator.StockMarketSimulator.entities.Company;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockMarketSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMarketSimulatorApplication.class, args);
	}
        

}
