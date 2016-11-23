<%-- 
    Document   : meuCadastro
    Created on : 22/11/2016, 22:08:47
    Author     : marco
--%>

<%@page import="br.com.cvlattes.model.User"%>
<%@page import="br.com.cvlattes.model.Moderator"%>
<%@page import="br.com.cvlattes.model.Institute"%>
<%@page import="br.com.cvlattes.model.adress.AddressType"%>
<%@page import="br.com.cvlattes.model.adress.StreetType"%>
<%@page import="br.com.cvlattes.controller.LoggableController"%>
<%@page import="java.util.Date"%>
<%@page import="br.com.cvlattes.controller.LoggableController"%>
<%@page import="br.com.cvlattes.model.Credential"%>
<%@page import="br.com.cvlattes.model.adress.City"%>
<%@page import="br.com.cvlattes.model.adress.Address"%>
<%@page import="br.com.cvlattes.model.adress.State"%>
<%@page import="br.com.cvlattes.model.adress.Country"%>
<%@page import="br.com.cvlattes.model.PersonName"%>
<%@page import="br.com.cvlattes.model.Person"%>
<%@page import="br.com.cvlattes.model.Loggable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meu Cadastro</title>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            Loggable loggable = (Loggable) session.getAttribute("usuario");
            Country country;
            State state;
            City city;
            Address address;
            Credential credential;
            String identifier;
            String password;
            String email;
            Date dataInicial;
            Date dataFinal;
            AddressType addressType;
            StreetType streetType;
            
            User usuario;

            if (loggable instanceof Moderator){
                response.sendRedirect("index.jsp");
            }
            
            if (loggable instanceof Person) {
                PersonName name;
                String firstName;
                String middleName;
                String lastName;

                usuario = (Person) loggable;
                name = (PersonName) usuario.getName();
                firstName = name.getFirst();
                middleName = name.getMiddle();
                lastName = name.getLast();

            } else {

                usuario = (Institute) loggable;
            }

            email = usuario.getEmail();
            credential = usuario.getCredential();
            identifier = credential.getIdentifier();
            password = credential.getPassword();
            
            LoggableController loggalbeController;


        %>

    </head>
    <body>


        <form class="form" method="post" action="Pessoa.do">
            <p>Meu Cadastro</p>
            <% %>
            <div class="form-group">
                <label for="firstName">Primeiro Nome</label>
                <input type="text" class="form-control" id="nome" name="firstName" value="<%=firstName%>" maxlength="50" required="yes"/>
            </div>
            <div class="form-group">
                <label for="middleName">Sobrenome</label>
                <input type="text" class="form-control" name="middleName" value="<%=middleName%>" maxlength="50"  />
            </div>
            <div class="form-group">
                <label for="lastName">Ultimo nome</label>
                <input type="text" class="form-control" name="lastName" value="<%=lastName%>" maxlength="50" required="yes" />
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" placeholder="email" name="email" value="<%=email%>"   />
            </div>
            <div class="form-group">
                <label for="cpf">CPF</label>
                <input type="text" class="form-control" placeholder="identifier" name="identifier" value="" maxlength="50"   />
            </div>
            <div class="form-group">
                <label for="password">Senha</label>
                <input type="text" class="form-control" placeholder="Senha" name="password" value="" maxlength="50"  />
            </div>
            <div class="form-group">
                <label for="dataInitEnd">Data Inicial do Endereço</label>
                <input type="date" class="form-control" name="dataInitEnd" value="" required=""  />
            </div>
            <div class="form-group">
                <label for="dataFinEnd">Data Final do Endereço</label>
                <input type="date" class="form-control" name="dataFinEnd" value=""  required="" />
            </div>
            <div class="form-group">
                <label for="tipoEnd">Tipo de Endereço</label><br>
                <input type="radio" name="Residencia" value="Residencia" checked=""> Residencia<br>
                <input type="radio" name="Trabalho" value="Trabalho"> Trabalho<br>
            </div>
            <div class="form-group">
                <label for="city">Cidade:</label>
                <input type="text" class="form-control" placeholder="Cidade" name="city" value="" maxlength="50"   />
            </div>
            <div class="form-group">
                <label for="state">Estado:</label>
                <input type="text" class="form-control" placeholder="Estado" name="state" value="" maxlength="50"   />
            </div>
            <div class="form-group">
                <label for="country">Pais</label>
                <input type="text" class="form-control" placeholder="Pais" name="country" value="" maxlength="50"   />
            </div>
            <div class="form-group">
                <label for="tipoLog">Tipo do Logradouro</label><br>
                <input type="radio" name="Avenida" value="Avenida" checked=""> Avenida<br>
                <input type="radio" name="Rua" value="Rua"> Rua<br>
            </div>
            <div class="form-group">
                <label for="street">Logradouro:</label>
                <input type="text" class="form-control" placeholder="Logradouro" name="street" value="" maxlength="50"   />
            </div>
            <div class="form-group">
                <label for="number">Número</label>
                <input type="text" class="form-control" placeholder="Numero" name="number" value="" maxlength="50"   />
            </div>
            <div class="form-group">
                <label for="cep">CEP</label>
                <input type="text" class="form-control" placeholder="CEP" name="cep" value="" maxlength="50"   />
            </div>
            <div class="form-group">
                <label for="complemento">Complemento</label>
                <input type="text" class="form-control" placeholder="Complemento" name="complemento" value="" maxlength="50"   />
            </div>

            <input class="btn btn-success" style="width: 100%" type="submit" id="submitData" value="Alterar"/>
            <a href="index.jsp"> Cancelar </a> 
        </form>
    </body>
</html>
