/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.servlets;

import br.com.cvlattes.controller.LoggableController;
import br.com.cvlattes.controller.exception.ItemNotFoundException;
import br.com.cvlattes.model.Credential;
import br.com.cvlattes.model.Institute;
import br.com.cvlattes.model.Loggable;
import br.com.cvlattes.model.Moderator;
import br.com.cvlattes.model.Person;
import br.com.cvlattes.persistence.LoggablePersistence;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author marco
 */
public class LoginServlet extends HttpServlet {

    private LoggableController loggableController;
    private LoggablePersistence loggablePersistence;
    private Loggable loggable;
    private Credential credential;
    private String identifier;
    private String password;
    private Person person;
    private Institute institute;
    private Moderator moderator;
    private HttpSession session;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        identifier = request.getParameter("login");
        password = request.getParameter("password");

        credential = new Credential(identifier, password);

        loggablePersistence = new LoggablePersistence();
        loggableController = new LoggableController(loggablePersistence);

        session = request.getSession();

        try {
            loggable = loggableController.login(credential);
            if (loggable instanceof Person) {
                person = (Person) loggable;
                session.setAttribute("person", person);
                response.sendRedirect("meuCadastro.jsp");
            } else if (loggable instanceof Institute) {
                institute = (Institute) loggable;
                session.setAttribute("intitute", institute);
                response.sendRedirect("meuCadastro.jsp");
            } else if (loggable instanceof Moderator) {
                moderator = (Moderator) loggable;
                session.setAttribute("moderator", moderator);
                response.sendRedirect("meuCadastro.jsp");
            }
        } catch (ItemNotFoundException ex) {
            response.sendRedirect("index.jsp");
//            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
