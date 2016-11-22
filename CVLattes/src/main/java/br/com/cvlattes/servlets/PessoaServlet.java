/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cvlattes.servlets;

import br.com.cvlattes.bin.CalendarioHelper;
import br.com.cvlattes.controller.LoggableController;
import br.com.cvlattes.model.Credential;
import br.com.cvlattes.model.Person;
import br.com.cvlattes.model.PersonName;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marco
 */
@WebServlet(name = "PessoaServlet", urlPatterns = {"/PessoaServlet"})
public class PessoaServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Country country;
    State state;
    City city;
    Address address;
    Credential credential;
    PersonName name;
    Person person;
    String email;
    LoggableController loggalbeController;
    Date dataInicial;
    Date dataFinal;
    AddressType addressType;
    StreetType streetType;
    LoggablePersistence loggablePersistence;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        
//        doador.setNomeMae(request.getParameter("nomeMae"));
//        
//        switch (request.getParameter("genero")) {
//            case "masculino":
//                doador.setSexo(Sexo.MASCULINO);
//            case "feminino":
//                doador.setSexo(Sexo.FEMENINO);
//            case "outro":
//                doador.setSexo(Sexo.OUTRO);
//        }
//        
//        doador.setDataNasc(CalendarioHelper.parseDate(request.getParameter("dataNasc")));
//        
//        doador.setProfissao(request.getParameter("profissao"));
//        

        name = new PersonName(request.getParameter("firstName"), request.getParameter("middleName"), request.getParameter("lastName"));
        email = request.getParameter("email");
        credential = new Credential(request.getParameter("cpf"), request.getParameter("password"));
//    datas
//tipo
        country = new Country(request.getParameter("country"), "");
        state = new State(request.getParameter("state"), "", country);
        city = new City(request.getParameter("city"), state);

        addressType = AddressType.valueOf("Trabalho");
        streetType = StreetType.valueOf("Rua");
        dataInicial = CalendarioHelper.parseDate(request.getParameter("dataInitEnd"));
        dataFinal = CalendarioHelper.parseDate(request.getParameter("dataFinEnd"));
        
        
        address = new Address(dataInicial, dataFinal, addressType, city, streetType, request.getParameter("street"), request.getParameter("number"), request.getParameter("cep"), request.getParameter("complemento"));

        person = new Person(name, credential);
        person.setEmail(email);
        person.addAddress(address);
        
        loggablePersistence = new LoggablePersistence();
        loggalbeController = new LoggableController(loggablePersistence);
        
        loggalbeController.add(person);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
