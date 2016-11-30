/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.servlets;

import br.com.cvlattes.controller.DocumentController;
import br.com.cvlattes.controller.LoggableController;
import br.com.cvlattes.controller.exception.ItemNotFoundException;
import br.com.cvlattes.model.Curriculum;
import br.com.cvlattes.model.Language;
import br.com.cvlattes.model.LanguageProficiency;
import br.com.cvlattes.model.Level;
import br.com.cvlattes.model.Person;
import br.com.cvlattes.model.Skill;
import br.com.cvlattes.model.adress.Country;
import br.com.cvlattes.persistence.DocumentPersistence;
import br.com.cvlattes.persistence.LoggablePersistence;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marco
 */
public class LanguageServlet extends HttpServlet {

    Curriculum curriculum;
    Country country;
    Language language;
    LanguageProficiency languageProficiency;
    Person person;
    HttpSession session;
    Map<Skill, Level> skills;
    Level level;
    LoggablePersistence loggablePersistence;
    LoggableController loggableController;
    DocumentPersistence documentPersistence;
    DocumentController documentController;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        person = (Person) session.getAttribute("person");

        country = new Country((String) request.getAttribute("pais"), "");
        language = new Language();
        language.setCountry(country);
        language.setLanguage((String) request.getParameter("language"));

        skills = new HashMap<Skill, Level>();
        level = Level.valueOf((String) request.getParameter("reading"));
        skills.put(Skill.valueOf("Reading"), level);

        level = Level.valueOf((String) request.getParameter("writing"));
        skills.put(Skill.valueOf("Writing"), level);

        level = Level.valueOf((String) request.getParameter("speaking"));
        skills.put(Skill.valueOf("Speaking"), level);

        level = Level.valueOf((String) request.getParameter("comprehension"));
        skills.put(Skill.valueOf("Comprehension"), level);

        languageProficiency = new LanguageProficiency(language, skills);

        curriculum = person.getCurriculum();
        curriculum.addLanguage(languageProficiency);
        person.setCurriculum(curriculum);

        loggablePersistence = new LoggablePersistence();
        loggableController = new LoggableController(loggablePersistence);

//        documentPersistence = new DocumentPersistence();
//        documentController = new DocumentController(documentPersistence);
        try {
            loggableController.update(person);
        } catch (ItemNotFoundException ex) {
            Logger.getLogger(LanguageServlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        session.setAttribute("person", person);

        response.sendRedirect("meuCurriculo.jsp");

    }
}
