/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.model;

import java.util.Collection;

/**
 *
 * @author marco
 */
public class Person extends User {

    private Curriculum curriculum;

    public Person(PersonName name, Credential credential) {
        super(name, credential);

    }

    public Person(String name, Credential credential) {
        super(name, credential);
        
        //implementar name

    }

    public String getCPF() {
        return super.getCredential().getIdentifier();
    }

    public void addDocument(Document document) {
    }

    public Document getDocument(Document document) {
        return document;
    }

    public void updateDocument(Document document) {

    }

    public void removeDocument(Document document) {

    }

//    public Collection<Document> listDocuments() {
//        return;
//    }    
}
