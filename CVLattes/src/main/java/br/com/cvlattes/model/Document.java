/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author marco
 */
public class Document implements Serializable{
    private Map<Person,Role> authorHasRole;
    private String title;
    private int year;
    private Institute institute;
    private Collection<String> keywords;
    private String researchArea;
    private Language language;

    public Document(Map<Person, Role> authorHasRole, String title, int year, Language language) {
        this.authorHasRole = authorHasRole;
        this.title = title;
        this.year = year;
        this.language = language;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public void setKeywords(Collection<String> keywords) {
        this.keywords = keywords;
    }

    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }

    public Institute getInstitute() {
        return institute;
    }

    public Collection<String> getKeywords() {
        return keywords;
    }

    public String getResearchArea() {
        return researchArea;
    }

    public Language getLanguage() {
        return language;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
    
    
    
}
