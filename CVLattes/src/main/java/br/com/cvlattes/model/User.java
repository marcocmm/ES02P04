/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.model;

import br.com.cvlattes.model.adress.Address;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public abstract class User extends Loggable {

    private Name name;
    private String email;
    private List<Address> address;

    public User(Name name, Credential credential) {
        super(credential);
        this.name = name;
        this.address = new ArrayList<Address>();
    }

    public User(String nameStr, Credential credential) {
        super(credential);

        //implementar this.name = nameStr;
    }

    public Name getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void addAddress(Address address) {
//        Tratar duplicatas
        this.address.add(address);
    }

    public void downloadDocument(Document document) {

    }

    public void updatePassword(String password) {

    }
}
