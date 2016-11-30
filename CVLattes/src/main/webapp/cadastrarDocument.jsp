<%-- 
    Document   : cadastrarDocumento
    Created on : 30/11/2016, 03:05:46
    Author     : marco
--%>

<%@page import="br.com.cvlattes.model.Person"%>
<%@page import="br.com.cvlattes.model.Person"%>
<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lates</title>
        <jsp:include page="header.jsp"></jsp:include>
        </head>
        <body>
        <%
            Enumeration attributes = session.getAttributeNames();
            String sessionType;
            Person person;

            if (attributes.hasMoreElements()) {
                sessionType = (String) attributes.nextElement();
                if (sessionType.equals("person")) {
                    person = (Person) session.getAttribute(sessionType);

                } else {
                    response.sendRedirect("index.jsp");
                }
            } else {
                response.sendRedirect("index.jsp");
            }
        %>
        <div class="container">
            <form class="form" name="formCadastro" method="post" action="Document.do">
                <div id="form_coluna1" class="form-group">
                    <label for="title">Titulo</label>
                    <input type="text" class="form-control" placeholder="title" name="title" value="" maxlength="50" required=""/>
                </div>
                <div id="form_coluna2" class="form-group">
                    <label for="year">Ano</label>
                    <input type="text" class="form-control" placeholder="year" name="year" value="" maxlength="50" required=""  />
                </div>
                <div id="form_coluna2" class="form-group">
                    <label for="institute">Institute</label>
                    <input type="text" class="form-control" placeholder="institute" name="institute" value="" maxlength="50" required=""  />
                </div>
                <div id="form_coluna2" class="form-group">
                    <label for="keywords">Palavras Cahves</label>
                    <input type="text" class="form-control" placeholder="keywords" name="keywords" value="" maxlength="50" required=""  />
                </div>
                <div id="form_coluna2" class="form-group">
                    <label for="researchArea">Area de pesquisa</label>
                    <input type="text" class="form-control" placeholder="researchArea" name="researchArea" value="" maxlength="50" required=""  />
                </div>
                <div id="form_coluna2" class="form-group">
                    <label for="language">Lingua</label>
                    <input type="text" class="form-control" placeholder="language" name="language" value="" maxlength="50" required=""  />
                </div>

                <input class="btn btn-success" style="width: 100%" type="submit" id="submitData" value="Cadastrar Documento"/>
            </form>
        </div>
    </body>
</html>
