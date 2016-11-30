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
public class Institute extends User {
    

    public Institute(InstituteName name, Credential credential) {
        super(name, credential);

    }

    public Institute(Credential credential, String name) {
        super(name, credential);
        //implementar name
    }

    public String getCNPJ() {
        return super.getCredential().getIdentifier();
    }


}
