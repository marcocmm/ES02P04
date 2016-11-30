/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.servlets;

import br.com.cvlattes.model.Institute;
import br.com.cvlattes.model.Language;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marco
 */
public class DocumentServlet extends HttpServlet {

    String title;
    int year;
    Institute institute;
    String keywords;
    String researchArea;
    String l;
    Language language;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        title = request.getParameter("title");
        
        
        
        
        
        response.sendRedirect("meuCurriculo.jsp");

    }
}
