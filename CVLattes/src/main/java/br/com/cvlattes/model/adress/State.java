/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.model.adress;

/**
 *
 * @author marco
 */
public class State {
    private String name;
    private String abbreviation;
    private Country country;

    public State(String name, String abbreviation, Country country) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.country = country;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public Country getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }
    
    
}
