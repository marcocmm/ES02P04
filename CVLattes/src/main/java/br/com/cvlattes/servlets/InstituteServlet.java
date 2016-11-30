/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.servlets;

import br.com.cvlattes.bin.CalendarioHelper;
import br.com.cvlattes.controller.LoggableController;
import br.com.cvlattes.model.Credential;
import br.com.cvlattes.model.Institute;
import br.com.cvlattes.model.InstituteName;
import br.com.cvlattes.model.adress.Address;
import br.com.cvlattes.model.adress.AddressType;
import br.com.cvlattes.model.adress.City;
import br.com.cvlattes.model.adress.Country;
import br.com.cvlattes.model.adress.State;
import br.com.cvlattes.model.adress.StreetType;
import br.com.cvlattes.persistence.LoggablePersistence;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marco
 */
public class InstituteServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Country country;
    private State state;
    private City city;
    private Address address;
    private Credential credential;
    private InstituteName name;
    private Institute institute;
    private String email;
    private LoggableController loggalbeController;
    private Date dataInicial;
    private Date dataFinal;
    private AddressType addressType;
    private StreetType streetType;
    private LoggablePersistence loggablePersistence;

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        name = new InstituteName(request.getParameter("name"));
        email = request.getParameter("email");
        credential = new Credential(request.getParameter("cpf"), request.getParameter("password"));
//    datas
//tipo
        country = new Country(request.getParameter("country"), "");
        state = new State(request.getParameter("state"), "", country);
        city = new City(request.getParameter("city"), state);

        addressType = AddressType.valueOf("Trabalho");
        streetType = StreetType.valueOf("Rua");
        dataInicial = CalendarioHelper.parseDate("01-01-2010");
        dataFinal = CalendarioHelper.parseDate("10-10-2016");

        address = new Address(dataInicial, dataFinal, addressType, city, streetType, request.getParameter("street"), request.getParameter("number"), request.getParameter("cep"), request.getParameter("complemento"));

        institute = new Institute(name, credential);
        institute.setEmail(email);
        institute.addAddress(address);

        loggablePersistence = new LoggablePersistence();
        loggalbeController = new LoggableController(loggablePersistence);

        loggalbeController.add(institute);

        response.sendRedirect("index.jsp");
    }

}
