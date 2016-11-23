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
public class Credential implements Serializable{
    private String identifier;
    private String password;

    public Credential(String identifier, String password) {
        this.identifier = identifier;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Credential){
            return ((Credential) obj).getIdentifier().equals(identifier);
        }
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getPassword() {
        return password;
    }
    
    
}
