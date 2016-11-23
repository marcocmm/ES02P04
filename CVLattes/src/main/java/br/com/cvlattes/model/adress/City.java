/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.model.adress;

import java.io.Serializable;

/**
 *
 * @author marco
 */
public class City implements Serializable{
    private String name;
    private State state;

    public City(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }
    
    
}
