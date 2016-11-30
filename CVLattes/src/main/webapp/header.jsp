<%-- 
    Document   : header
    Created on : 15/11/2016, 16:10:49
    Author     : Marco Cezar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="resources/css/header.css">
        <link rel="stylesheet" href="resources/css/styleMenu.css">
        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
    <div class="header textHeader">CVLattes</div>

    <nav id="cssmenu">
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="consultarCurriculo.jsp">Consultar Curriculo</a></li>
            <li><a class="active" href="#">Cadastro</a>
                <ul>
                    <li><a href="cadastroPessoa.jsp">Cadastrar Pessoa</a></li>
                    <li><a href="cadastroInstituicao.jsp">Cadastrar Instituição</a>

                </ul>
            </li>
            <li><a href="meuCadastro.jsp">Meu Cadastro</a></li>
            <li><a href="meuCurriculo.jsp">Meu Curriculo</a></li>

            </li>
        </ul>
    </nav>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="resources/js/scriptMenu.js"></script>
</html>
