/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.model;

import java.io.Serializable;

/**
 *
 * @author marco
 */
public class InstituteName extends Name implements Serializable {

    private String name;

    public InstituteName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

}
