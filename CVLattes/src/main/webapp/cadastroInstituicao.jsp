<%-- 
    Document   : cadastroInstituicao
    Created on : 22/11/2016, 23:44:16
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Instituição</title>
        <jsp:include page="header.jsp"></jsp:include>

    </head>
    <body>
        <form class="form" method="post" action="Institute.do">
            <div class="form-group">
                <label for="name">Nome</label>
                <input type="text" class="form-control" placeholder="Nome" name="name" value="" maxlength="50" required="yes" />
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" placeholder="email" name="email" value=""   />
            </div>
            <div class="form-group">
                <label for="cpf">CNPJ</label>
                <input type="text" class="form-control" placeholder="CPF" name="cpf" value="" maxlength="50"   />
            </div>
            <div class="form-group">
                <label for="password">Senha</label>
                <input type="text" class="form-control" placeholder="Senha" name="password" value="" maxlength="50"  />
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

            <input class="btn btn-success" style="width: 100%" type="submit" id="submitData" value="Cadastrar"/>
        </form>
    </body>
</html>
