/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author marco
 */
public abstract class Loggable implements Serializable{
    private Credential credential;

    public Loggable(Credential credential) {
        this.credential = credential;
    }
    
    public void login(){
    }
    public void logout(){
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
