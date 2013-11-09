<%-- 
    Document   : index.jsp
    Created on : 30/10/2013, 18:37:21
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <div class="cadForm centered">
            <form action="RetornaResultado" method="post">
                <h2>Formulário</h2>

                <div class="group-form">
                    <label for="nome">Nome</label>
                    <input name="nome" id="nome" type="text">
                </div>

                <div class="group-form">
                    <label for="sexo">Sexo</label>
                    <input type="radio" name="sexo" id="sexo" value="M"> <span>Masculino</span>
                    <br>
                    <input type="radio" name="sexo" id="sexo" value="F"> <span>Feminino</span>
                </div>

                <div class="group-form">
                    <label for="idade">Idade</label>
                    <select name="idade" id="idade">
                        <option value="crianca">0-12</option>
                        <option value="adolescente">13-18</option>
                        <option value="adulto">19-60</option>
                        <option value="idoso">61 em diante</option>
                    </select>
                </div>

                <div class="group-form">
                    <input type="submit" id="cadastrar" name="cadastrar" value="Cadastrar">
                </div>
            </form>
        </div>	
    </body>
</html>
