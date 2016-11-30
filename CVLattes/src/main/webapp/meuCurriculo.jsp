<%-- 
    Document   : meuCurriculo
    Created on : 29/11/2016, 23:31:55
    Author     : marco
--%>

<%@page import="br.com.cvlattes.model.Skill"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.cvlattes.model.LanguageProficiency"%>
<%@page import="br.com.cvlattes.model.Curriculum"%>
<%@page import="br.com.cvlattes.model.Person"%>
<%@page import="br.com.cvlattes.model.Person"%>
<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Enumeration attributes = session.getAttributeNames();
        String sessionType;
        Person person = null;

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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lates</title>
        <jsp:include page="header.jsp"></jsp:include>
        </head>
        <body>
            <div class="texto">

                <a href="cadastrarLingua.jsp">Cadastrar Lingua</a>
                </br>
                <a href="cadastrarDocumento.jsp">Cadastrar Documento</a>


            <%
                Curriculum curriculum;
                ArrayList<LanguageProficiency> languageProficiency;
                curriculum = person.getCurriculum();
                languageProficiency = (ArrayList<LanguageProficiency>) curriculum.getLanguages();
                for (LanguageProficiency language : languageProficiency) {
                    out.println("<h2> Lingua: " + language.getLanguage().getLanguage() + "</h2>");
                    out.println("");
                    for (Skill s : language.getSkills().keySet()) {
                        out.println("<h3>"+s+":  "+language.getSkills().get(s) + "</h2>");
                    }
                }
            %>
        </div>
    </body>
</html>
