<%-- 
    Document   : cadastrarLingua
    Created on : 30/11/2016, 01:01:59
    Author     : marco
--%>

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
            <form class="form" name="formCadastro" method="post" action="Language.do">
                <div id="form_coluna1" class="form-group">
                    <label for="language">Lingua</label>
                    <input type="text" class="form-control" placeholder="Lingua" name="language" value="" maxlength="50" required=""/>
                </div>
                <div id="form_coluna2" class="form-group">
                    <label for="pais">Pais Origem da Lingua</label>
                    <input type="text" class="form-control" placeholder="Pais" name="pais" value="" maxlength="50" required=""  />
                </div>
                
                
                <div id="form_coluna2" class="form-group">
                    <label for="reading">Leitura</label><br>
                    <input type="radio" name="reading" value="Bom" checked=""> Bom<br>
                    <input type="radio" name="reading" value="Razoavel"> Razoavel<br>
                    <input type="radio" name="reading" value="Baixo"> Baixo
                </div>
                
                <div id="form_coluna2" class="form-group">
                    <label for="writing">Escrita</label><br>
                    <input type="radio" name="writing" value="Bom" checked=""> Bom<br>
                    <input type="radio" name="writing" value="Razoavel"> Razoavel<br>
                    <input type="radio" name="writing" value="Baixo"> Baixo
                </div>
                
                <div id="form_coluna2" class="form-group">
                    <label for="speaking">Fala</label><br>
                    <input type="radio" name="speaking" value="Bom" checked=""> Bom<br>
                    <input type="radio" name="speaking" value="Razoavel"> Razoavel<br>
                    <input type="radio" name="speaking" value="Baixo"> Baixo
                </div>
                
                <div id="form_coluna2" class="form-group">
                    <label for="comprehension">Compreensão</label><br>
                    <input type="radio" name="comprehension" value="Bom" checked=""> Bom<br>
                    <input type="radio" name="comprehension" value="Razoavel"> Razoavel<br>
                    <input type="radio" name="comprehension" value="Baixo"> Baixo
                </div>
                
                <input class="btn btn-success" style="width: 100%" type="submit" id="submitData" value="Cadastrar Doador"/>
            </form>
        </div>
    </body>
</html>
