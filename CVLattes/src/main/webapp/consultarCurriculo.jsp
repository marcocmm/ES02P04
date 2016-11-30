<%-- 
    Document   : consultarCurriculo
    Created on : 29/11/2016, 23:25:32
    Author     : marco
--%>

<%@page import="br.com.cvlattes.model.InstituteName"%>
<%@page import="br.com.cvlattes.model.Person"%>
<%@page import="br.com.cvlattes.model.Loggable"%>
<%@page import="br.com.cvlattes.controller.LoggableController"%>
<%@page import="br.com.cvlattes.persistence.LoggablePersistence"%>
<%@page import="br.com.cvlattes.model.Skill"%>
<%@page import="br.com.cvlattes.model.LanguageProficiency"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.cvlattes.model.Curriculum"%>
<%@page import="br.com.cvlattes.model.Document"%>
<%@page import="br.com.cvlattes.model.Document"%>
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

            <%
                LoggablePersistence loggablePersistence = new LoggablePersistence();
                LoggableController loggableController = new LoggableController(loggablePersistence);
                ArrayList<Document> documents;
                Curriculum curriculum;
                ArrayList<LanguageProficiency> languageProficiency;
                Person person;
                ArrayList<Loggable> loggables = (ArrayList<Loggable>) loggableController.getItems();
                for (Loggable l : loggables) {
                    if (l instanceof Person) {
                        person = (Person) l;
                        curriculum = person.getCurriculum();
                        languageProficiency = (ArrayList<LanguageProficiency>) curriculum.getLanguages();
                        if (languageProficiency != null) {
                            for (LanguageProficiency language : languageProficiency) {
                                if (language.getLanguage().getLanguage() != null) {
                                    out.println("<h2> Lingua: " + language.getLanguage().getLanguage() + "</h2>");
                                    if (language.getSkills() != null) {
                                        for (Skill s : language.getSkills().keySet()) {
                                            out.println("<h3>" + s + ":  " + language.getSkills().get(s) + "</h2>");
                                        }
                                    }
                                }
                            }
                        }
                        documents = (ArrayList<Document>) person.getDocuments();
                        for (Document document : documents) {
                            out.println("<h2> Titulo do documento: " + document.getTitle() + "</h2>");
                            out.println("<h3> Ano: " + document.getYear() + "</h3>");
                            out.println("<h3> Instituição: " + ((InstituteName)document.getInstitute().getName()).getName()+ "</h3>");
                            out.println("<h3> Palabras chaves: " + document.getKeywords() + "</h3>");
                            out.println("<h3> Area de pesquisa: " + document.getResearchArea() + "</h3>");
                            out.println("<h3> Lingua de escrita: " + document.getLanguage().getLanguage() + "</h3>");
                        }
                    }
                }
            %>
        </div>

    </body>
</html>
