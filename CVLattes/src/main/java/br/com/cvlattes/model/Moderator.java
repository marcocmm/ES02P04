/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.model;

/**
 *
 * @author marco
 */
public class Moderator extends Loggable{
    private Credential credential;

    public Moderator(Credential credential) {
        super(credential);
    }

    
    public void deleteUser(User user){
    }
}
