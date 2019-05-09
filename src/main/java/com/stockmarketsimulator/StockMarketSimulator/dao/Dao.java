/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockmarketsimulator.StockMarketSimulator.dao;

import java.util.List;


/**
 *
 * @author jacqu
 */
public interface Dao<E> {

    public void save(E e);
    
    public void saveAll(List<E> e);

    public E getById(int id);

    public List<E> getAll();

    public void update(E e);

    public void delete(int id);

}
