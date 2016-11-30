/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.model;

import br.com.cvlattes.controller.LoggableController;
import br.com.cvlattes.controller.exception.ItemNotFoundException;
import br.com.cvlattes.persistence.LoggablePersistence;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marco
 */
public class LanguageTest {

    public LanguageTest() {
    }

    @Test
    public void testSomeMethod() {
        Person person = new Person(new PersonName("oi"), new Credential("rmeloca", "meloca"));
        LanguageProficiency languageProficiency = new LanguageProficiency(new Language(), null);
        Curriculum curriculum = person.getCurriculum();
        curriculum.addLanguage(languageProficiency);
        LoggablePersistence loggablePersistence = new LoggablePersistence();
        LoggableController loggableController = new LoggableController(loggablePersistence);
        loggableController.add(person);
    }

    @Test
    public void getFromDatabase() {
        LoggablePersistence loggablePersistence = new LoggablePersistence();
        LoggableController loggableController = new LoggableController(loggablePersistence);
        try {
            Loggable login = loggableController.login(new Credential("rmeloca", "meloca"));

            Person person = (Person) login;
            LanguageProficiency languageProficiency = new LanguageProficiency(new Language(), null);
            Curriculum curriculum = person.getCurriculum();
            curriculum.addLanguage(languageProficiency);

        } catch (ItemNotFoundException ex) {
            Assert.fail();
        }
    }

}
