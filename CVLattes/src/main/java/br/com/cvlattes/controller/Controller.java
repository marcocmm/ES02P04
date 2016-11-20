/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.controller;

import br.com.cvlattes.persistence.Persistence;
import java.util.List;

/**
 *
 * @author marco
 */
public class Controller<T> {

    Persistence<T> persistence;

    public Controller(Persistence<T> persistence) {
        this.persistence = persistence;
    }
    
       
    public List<T> getItems() {

        return null;
    }

    public void add(T t) {

    }

    public void remove(T t) {
    }

    public void update(T t) {
    }

    public T get(T t) {
        return null;
    }
}
