/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.model;

import br.com.cvlattes.model.adress.Country;
import java.io.Serializable;

/**
 *
 * @author marco
 */
public class Language implements Serializable {

    private String language;
    private Country country;
    private String abbreviation;

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Language() {
        this.abbreviation = "";
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
