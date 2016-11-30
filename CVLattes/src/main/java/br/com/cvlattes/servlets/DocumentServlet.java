/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.servlets;

import br.com.cvlattes.controller.LoggableController;
import br.com.cvlattes.controller.exception.ItemNotFoundException;
import br.com.cvlattes.model.Credential;
import br.com.cvlattes.model.Document;
import br.com.cvlattes.model.Institute;
import br.com.cvlattes.model.InstituteName;
import br.com.cvlattes.model.Language;
import br.com.cvlattes.model.Person;
import br.com.cvlattes.model.Role;
import br.com.cvlattes.persistence.LoggablePersistence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class DocumentServlet extends HttpServlet {

    private String title;
    private int year;
    private Institute institute;
    private String instituteName;
    private String keywords;
    private String researchArea;
    private String l;
    private Language language;
    private Document document;
    private Map<Person, Role> authorHasRole;
    private Person person;
    private HttpSession session;
    private LoggablePersistence loggablePersistence;
    private LoggableController loggableController;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        person = (Person) session.getAttribute("person");

        title = request.getParameter("title");
        year = Integer.parseInt(request.getParameter("year"));
        instituteName = request.getParameter("institute");
        institute = new Institute(new InstituteName(instituteName), new Credential(instituteName, instituteName));
        keywords = request.getParameter("keywords");
        researchArea = request.getParameter("researchArea");
        language = new Language();
        language.setLanguage(request.getParameter("language"));
        authorHasRole = new HashMap<>();
        authorHasRole.put(person, Role.Autor);

        document = new Document(authorHasRole, title, year, language);
        document.setInstitute(institute);
        document.setKeywords(Arrays.asList(keywords.split(" ")));
        document.setResearchArea(researchArea);
        
        person.getCurriculum().addDocument(document);

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
