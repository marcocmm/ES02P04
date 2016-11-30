/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author marco
 */
public class Curriculum implements Serializable {

    private Person user;
    Collection<Document> documents;
    Collection<LanguageProficiency> languages;
    Map<Document, Achievement> achievements;

    public Curriculum(Person user) {
        this.user = user;
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

}
