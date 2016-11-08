/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Map;

/**
 *
 * @author marco
 */
public class LanguageProficiency {
    Language language;
    Map<Skill, Level> skillHasLevel;

    public LanguageProficiency(Language language, Map<Skill,Level> skills) {
        this.language = language;
        this.skillHasLevel = skillHasLevel;
    }

    public Language getLanguage() {
        return language;
    }

    public Map<Skill, Level> getSkills() {
        return skillHasLevel;
    }
    
    
    
}
