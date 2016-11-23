<%-- 
    Document   : meuCadastro
    Created on : 22/11/2016, 22:08:47
    Author     : marco
--%>

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
            Person usuario;
            PersonName name;
            
            usuario = (Person) session.getAttribute("person");
            name = (PersonName)usuario.getName();
        %>

    </head>
    <body>


        <form class="form" method="post" action="Pessoa.do">
            <p>Meu Cadastro</p>
            <div class="form-group">
                <label for="firstName">Primeiro Nome</label>
                <input type="text" class="form-control" placeholder="<%name.getFirst();%>" id="nome" name="firstName" value="<%name.getFirst();%>" maxlength="50" required="yes"/>
            </div>
            <div class="form-group">
                <label for="middleName">Sobrenome</label>
                <input type="text" class="form-control" placeholder="Sobrenome" name="middleName" value="<%((PersonName)usuario.getName()).getMiddle();%>" maxlength="50"  />
            </div>
            <div class="form-group">
                <label for="lastName">Ultimo nome</label>
                <input type="text" class="form-control" placeholder="Ultimo Nome" name="lastName" value="<%((PersonName)usuario.getName()).getLast();%>" maxlength="50" required="yes" />
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" placeholder="email" name="email" value=""   />
            </div>
            <div class="form-group">
                <label for="cpf">CPF</label>
                <input type="text" class="form-control" placeholder="CPF" name="cpf" value="" maxlength="50"   />
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
