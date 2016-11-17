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
    
    private String cnpj;

    public Institute(Credential credential, InstituteName name, String cnpj) {
        super(name, credential);
        this.cnpj = cnpj;

    }

    public Institute(Credential credential, String name, String cnpj) {
        super(name, credential);
        this.cnpj = cnpj;
        //implementar name
    }

    public String getCNPJ() {
        return cnpj;
    }


}
