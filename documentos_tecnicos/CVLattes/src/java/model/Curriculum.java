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
public class Curriculum {
 private Person user;
    Collection<Document> documents;
    Collection<LanguageProficiency> languages;
    Map<Document,Achievement> achievements;

    public Curriculum(User user) {
    }
    
    
}
