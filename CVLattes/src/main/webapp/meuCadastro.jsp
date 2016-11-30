<%-- 
    Document   : meuCadastro
    Created on : 22/11/2016, 22:08:47
    Author     : marco
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="br.com.cvlattes.model.InstituteName"%>
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

        </head>
        <body>



        <%
            Enumeration attributes = session.getAttributeNames();
            String country = "";
            String state = "";
            String city = "";
            Address address;
            String street = "";
            int number = 0;
            int cep = 0;
            String complemento = "";
            String identifier = "";
            String password = "";
            Credential credential = new Credential(identifier, password);
            String email = "";
            String sessionType;
            Loggable loggable = new Loggable(credential) {
            };
            if (attributes.hasMoreElements()) {
                sessionType = (String) attributes.nextElement();
                loggable = (Loggable) session.getAttribute(sessionType);

                if (sessionType.equals("person")) {
                    Person usuario = (Person) loggable;

                    PersonName name;
                    String firstName;
                    String middleName;
                    String lastName;

                    usuario = (Person) loggable;
                    name = (PersonName) usuario.getName();
                    firstName = name.getFirst();
                    middleName = name.getMiddle();
                    lastName = name.getLast();

                    out.println("<form class=\"form\" method=\"post\" action=\"Pessoa.do\">"
                            + "<p>Meu Cadastro</p>"
                            + "<div class=\"form-group\">"
                            + "<label for=\"firstName\">Primeiro Nome</label>"
                            + "<input type=\"text\" class=\"form-control\" id=\"nome\" name=\"firstName\" value=" + firstName + " maxlength=\"50\" required=\"yes\"/>"
                            + "</div>"
                            + "<div class=\"form-group\">"
                            + "<label for=\"middleName\">Nome do Meio</label>"
                            + "<input type=\"text\" class=\"form-control\" id=\"nome\" name=\"middleName\" value=" + middleName + " maxlength=\"50\" required=\"yes\"/>"
                            + "</div>"
                            + "<div class=\"form-group\">"
                            + "<label for=\"lastName\">Ultimo Nome</label>"
                            + "<input type=\"text\" class=\"form-control\" id=\"nome\" name=\"lastName\" value=" + lastName + " maxlength=\"50\" required=\"yes\"/>"
                            + "</div>"
                            + "");
                    email = usuario.getEmail();
                    address = ((ArrayList<Address>) usuario.getAddress()).get(0);
                    city = address.getCity().getName();
                    state = address.getCity().getState().getName();
                    country = address.getCity().getState().getCountry().getName();
                    street = address.getStreet();
                    number = address.getNumber();
                    cep = address.getCep();
                    complemento = address.getComplemento();
                } else if (sessionType.equals("person")) {
                    Institute usuario;
                    String name;
                    usuario = (Institute) loggable;
                    name = ((InstituteName) usuario.getName()).toString();
                    System.out.println("<form class=\"form\" method=\"post\" action=\"Institute.do\">"
                            + "<p>Meu Cadastro</p>"
                            + "<div class=\"form-group\">"
                            + "<label for=\"name\">Nome</label>"
                            + "<input type=\"text\" class=\"form-control\" id=\"nome\" name=\"name\" value=" + name + " maxlength=\"50\" required=\"yes\"/>"
                            + "</div>");
                    email = usuario.getEmail();
                    address = ((ArrayList<Address>) usuario.getAddress()).get(0);
                    city = address.getCity().getName();
                } else {
                    response.sendRedirect("index.jsp");
                }
            } else {
                response.sendRedirect("index.jsp");
            }

            credential = loggable.getCredential();
            identifier = credential.getIdentifier();
            password = credential.getPassword();
        %>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" placeholder="email" name="email" value="<%=email%>"  readonly="" />
        </div>
        <div class="form-group">
            <label for="cpf">CPF: <%=identifier%></label>
        </div>
        <div class="form-group">
            <label for="password">Senha</label>
            <input type="password" class="form-control" placeholder="Senha" name="password" value="<%=password%>" maxlength="50"  />
        </div>

        <div class="form-group">
            <label for="city">Cidade:</label>
            <input type="text" class="form-control" placeholder="Cidade" name="city" value="<%=city%>" maxlength="50"   />
        </div>
        <div class="form-group">
            <label for="state">Estado:</label>
            <input type="text" class="form-control" placeholder="Estado" name="state" value="<%=state%>" maxlength="50"   />
        </div>
        <div class="form-group">
            <label for="country">Pais</label>
            <input type="text" class="form-control" placeholder="Pais" name="country" value="<%=country%>" maxlength="50"   />
        </div>

        <div class="form-group">
            <label for="street">Logradouro:</label>
            <input type="text" class="form-control" placeholder="Logradouro" name="street" value="<%=street%>" maxlength="50"   />
        </div>
        <div class="form-group">
            <label for="number">Número</label>
            <input type="text" class="form-control" placeholder="Numero" name="number" value="<%=number%>" maxlength="50"   />
        </div>
        <div class="form-group">
            <label for="cep">CEP</label>
            <input type="text" class="form-control" placeholder="CEP" name="cep" value="<%=cep%>" maxlength="50"   />
        </div>
        <div class="form-group">
            <label for="complemento">Complemento</label>
            <input type="text" class="form-control" placeholder="Complemento" name="complemento" value="<%=complemento%>" maxlength="50"   />
        </div>

        <input class="btn btn-success" style="width: 100%" type="submit" id="submitData" value="Alterar"/>
        </br>
        <a href="index.jsp"> Cancelar </a> 
        </br>
    </form>
</body>
</html>
