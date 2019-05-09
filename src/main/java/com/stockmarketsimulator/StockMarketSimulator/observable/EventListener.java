/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.observable;


/**
 *
 * @author fernandoms
 */
public interface EventListener<E> {
    abstract void update(String eventType, E item);
}
