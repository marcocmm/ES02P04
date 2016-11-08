/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author marco
 */
public class Credential {
    private String identifier;
    private String password;

    public Credential(String identifier, String password) {
        this.identifier = identifier;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
