<%-- 
    Document   : index
    Created on : 15/11/2016, 18:10:00
    Author     : marco
--%>

<%@page import="br.com.cvlattes.model.Loggable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lates</title>
        <jsp:include page="header.jsp"></jsp:include>
    </head>
    <body>
        <div class="texto">
            <h1>Bem vindo!</h1>
        </div>

        <form class="form" method="post" action="Login.get">
            <div class="form-group">
                <label for="login">Login</label>
                <input type="text" class="form-control" placeholder="Login" name="login" value="" maxlength="50"   />
            </div>
            <div class="form-group">
                <label for="password">Senha</label>
                <input type="password" class="form-control" placeholder="Senha" name="password" value="" maxlength="50"  />
            </div>
            <input class="btn btn-success" style="width: 100%" type="submit" id="submitData" value="Login"/>
        </form>

        <div class="texto">

            <a href="cadastroPessoa.jsp">Cadastro Pessoa</a>
            </br>
            <a href="cadastroInstituicao.jsp">Cadastro Instituição</a>
            </br>
            <a href="esqueceuSenha.jsp">Esqueceu sua senha?</a>
        </div>
    </body>
</html>
