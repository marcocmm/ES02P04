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
public class Person extends User {

    private Curriculum curriculum;

    public Person(PersonName name, Credential credential) {
        super(name, credential);
        this.curriculum = new Curriculum(this);
    }

//    public Person(String name, Credential credential) {
//        super(name, credential);
//        this.curriculum = new Curriculum(this);
//        //implementar name
//    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public String getCPF() {
        return super.getCredential().getIdentifier();
    }

    public void addDocument(Document document) {
    }

    public Curriculum getCurriculum() {
        return this.curriculum;
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
