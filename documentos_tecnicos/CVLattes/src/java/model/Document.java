/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collection;
import java.util.Map;

/**
 *
 * @author marco
 */
public class Document {
    private Map<Person,Role> authorHasRole;
    private String title;
    private byte year;
    Institute institute;
    Collection<String> keywords;
    String researchArea;
    Language language;

    public Document(Map<Person, Role> authorHasRole, String title, byte year, Language language) {
        this.authorHasRole = authorHasRole;
        this.title = title;
        this.year = year;
        this.language = language;
    }
    
    
}
