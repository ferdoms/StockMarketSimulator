/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fernandoms
 */

@RestController
@RequestMapping("/company") 
public class CompanyController {
    
    
     
    @GetMapping("/teste") // Finds all stored lecturers in a pageable format
    public String teste(){
        return "teste";
    }
    
}