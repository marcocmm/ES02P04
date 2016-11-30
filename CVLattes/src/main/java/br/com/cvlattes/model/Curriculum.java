/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marco
 */
public class Curriculum implements Serializable {

    private Person user;
    private Collection<Document> documents;
    private Collection<LanguageProficiency> languages;
    private Map<Document, Achievement> achievements;

    public Curriculum(Person user) {
        this.user = user;
        this.documents = new ArrayList<>();
        this.languages = new ArrayList<>();
        this.achievements = new HashMap<>();
    }

    public void setAchievements(Map<Document, Achievement> achievements) {
        this.achievements = achievements;
    }

    public void addDocument(Document document) {
        ((ArrayList<Document>) documents).add(document);
    }

    public void addLanguage(LanguageProficiency language) {
        ((ArrayList<LanguageProficiency>) languages).add(language);
    }

    public Collection<Document> getDocuments() {
        return documents;
    }

    public Collection<LanguageProficiency> getLanguages() {
        return languages;
    }
    
}
